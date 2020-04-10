INSERT INTO `Person` VALUES (1,_binary '¬í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0Åx','tamir','Baldandorj',''),(2,_binary '¬í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0Á\nx','Enkhbayar','Batjargal',''),(3,_binary '¬í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0½	x','Dany','Huambo','');
INSERT INTO `Authority` VALUES (1,'USER_ROLE','Tamir'),(2,'USER_ROLE','Eegii'),(3,'USER_ROLE','Dani');
INSERT INTO `CREDENTIALS` VALUES ('Dani',_binary '','$2a$10$MbrJt5kp6S3lxakAnAptW.WAmho6PsCb6n0oE8onPZk7s6.00vxje'),('Eegii',_binary '','$2a$10$7CS2pAIWemMkoDWNX.d7K.viHCUawtqqwekKVHzZKMFoc7OTBuKRO'),('Tamir',_binary '','$2a$10$.SP7Xj5UqPdL.GPpKj0wqODiSuE5nsVp1ulpI2sNZwDDzCxf5zHf2');
INSERT INTO `User` VALUES(1,'tamir@nso.mn','1','Tamir');

INSERT INTO `Address` VALUES (1,'Duarte','CA','Lower River St',91010),(2,'Canandaigua','NY','Lakewood',14424);

INSERT INTO `Property` VALUES (1,2,NULL,1,'Great studio! Bed was extremely comfortable. Wonderful attention to detail.',1,NULL,40,NULL,NULL,1,'AVIALABLE','HOUSE',1,NULL),(2,2,NULL,1,'Old Smock Mill is a romantic place for couples. The atmosphere inside is peaceful and relaxing.',1,NULL,60,NULL,NULL,1,'AVIALABLE','APARTMENT',2,NULL);
INSERT INTO `Booking` VALUES (1,'2020-02-07 00:00:00','2020-02-09 00:00:00',2,NULL,1,1,NULL);
