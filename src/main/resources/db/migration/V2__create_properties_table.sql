CREATE TABLE properties (
  propertyId int(11) NOT NULL AUTO_INCREMENT,
  address varchar(225) DEFAULT NULL,
  latitude double DEFAULT NULL,
  longitude double DEFAULT NULL,
  distance double DEFAULT NULL,
  createdon datetime NOT NULL,
  updatedon datetime DEFAULT NULL,
  PRIMARY KEY (propertyId)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1