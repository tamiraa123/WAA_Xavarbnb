package edu.miu.xavarbnb.controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.miu.xavarbnb.domain.Amenity;
import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.domain.PropertyStatus;
import edu.miu.xavarbnb.domain.PropertyType;
import edu.miu.xavarbnb.service.AmenityService;
import edu.miu.xavarbnb.service.PropertyService;

@Controller
@RequestMapping(value = "/property")
public class PropertyController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	AmenityService amenityService;
	
	Session session;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(@ModelAttribute("newProperty") Property property,Model model) {
		model.addAttribute("types", PropertyType.values());
		model.addAttribute("statuses", PropertyStatus.values());
		return "addProperty";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProperty(@Valid @ModelAttribute("newProperty") Property property, BindingResult result, RedirectAttributes redirect, Model model) throws SQLException {	
		
		MultipartFile image = property.getPropertyImage();
		System.out.println("HHHHHHHH: " + image);
		// isEmpty means file exists BUT NO Content
		// Could also check content type productImage.getContentType() for image
		if (image != null && !image.isEmpty()) {
			try {
				// Write a PNG image file
				File outputfile = new File(File.separator + "resource" + File.separator + "images"
						+ File.separator + property.getId() + ".png");
				//BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
				//ImageIO.write(bufferedImage, "PNG", outputfile);
				image.transferTo(outputfile);
				property.setImagePath(outputfile.getPath());
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		propertyService.save(property);
		redirect.addFlashAttribute("propertyId", property.getId());
		return "redirect:/property/newproperty";
	}

	@RequestMapping(value = "/addAmenity", method = RequestMethod.POST)
    public @ResponseBody Amenity addAmenity(@Valid @RequestBody Amenity amenity) {
		Property property = propertyService.findPropertyById(amenity.getPropertyId());
		property.addAmenity(amenity);
		amenityService.save(amenity);
		propertyService.save(property);
        return amenity;
    }
	
	@RequestMapping(value = "/newproperty", method = RequestMethod.GET)
	public String getProperty(@ModelAttribute("property") Property property, Model model) {
		property = propertyService.findPropertyById((Long) model.asMap().get("propertyId"));
		model.addAttribute("property", property);
		return "property";
	}
	
	@RequestMapping(value = "/property/{propertyId}", method = RequestMethod.GET)
	public String getPropertyDetail(@ModelAttribute("property") Property property, @PathVariable("propertyId") Long propertyId, Model model) {
		property = propertyService.findPropertyById(propertyId);
		model.addAttribute("property", property);
		return "propertyDetail";
	}
	
	/*
	 * @RequestMapping(value = "/image/{imageId}", method = RequestMethod.GET)
	 * public String getImage(Model model, @PathVariable("imageId") String category)
	 * {
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateProperty(@ModelAttribute("updatedProperty") Property property, BindingResult result, Model model) {
		propertyService.save(property);
		return "welcome";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteProperty(@RequestParam("id") Long id, Model model) {
		propertyService.delete(id);
		return "welcome";
	}
	
	
	
	@RequestMapping(value = "/byFilter", method = RequestMethod.GET)
	public String getByFilter(@RequestParam("city") String city, @RequestParam("minPrice") Double minPrice, 
			@RequestParam("maxPrice") Double maxPrice, @RequestParam("capacity") Integer capacity, Model model) {
		System.out.println("HAHAHAHAHHAHAHAHA" + city + minPrice + maxPrice + capacity);
		if(minPrice == null) minPrice = 0.0;
		if(maxPrice == null) maxPrice = 1000000.0;
		if(capacity == null) capacity = 1;
		
		List<Property> properties = propertyService.getPropertiesByFilter(city, minPrice, maxPrice, capacity);
		model.addAttribute("properties", properties);
		return "welcome";
	}
	
	@RequestMapping(value = "/byStatus", method = RequestMethod.GET)
	public String getByStatus(@RequestParam("status") PropertyStatus status, Model model) {
		List<Property> properties = propertyService.getPropertiesByStatus(status);
		model.addAttribute("properties", properties);
		return "welcome";
	}
	
	@RequestMapping(value = "/byOwner", method = RequestMethod.GET)
	public String getByOwner(@RequestParam("id") Long id, Model model) {
		List<Property> properties = propertyService.getPropertiesByOwner(id);
		model.addAttribute("properties", properties);
		return "welcome";
	}
	
	@RequestMapping(value = "/updateRating", method = RequestMethod.PATCH)
	public String updateRating(@RequestParam("id") Long id, @RequestParam("rating") Double rating, Model model) {
		Double newRating = rating;
		Property property = propertyService.findPropertyById(id);
		Integer c = property.getBookedNumber() + 1;
		Double r = property.getRating();
		r = (r * (c - 1) + newRating)/c;
		property.setRating(r);
		property.setBookedNumber(c);
		propertyService.save(property);
		return "welcome";
	}
}