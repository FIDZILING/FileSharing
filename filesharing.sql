# Database Name` is filesharing
# Host: 127.0.0.1  (Version 5.7.18-log)
# Date: 2018-05-23 11:06:51
# Generator: MySQL-Front 5.4  (Build 4.34)
# Internet: http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "fileinfo"
#

DROP TABLE IF EXISTS `fileinfo`;
CREATE TABLE `fileinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `creator` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `downloadTimes` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8;

#
# Data for table "fileinfo"
#

INSERT INTO `fileinfo` VALUES (23,'webexp-css&js.rar','root','this is our file',9),(123,'实例no下载','root','不能下载啊啊啊',16),(124,'error.gif','wrl','图片',2),(222,'User_Server.java','root','asd',2),(245,'User_Server.java','root','啊吧从',2),(255,'我是神.TXT','root','啊吧从',1),(256,'filesharing.sql','wrl','测试文件',1),(1000,'gimp-2.10.0-setup-2.exe','lszj','1000',0),(1001,'jdk-8u152-windows-x64.exe','lszj','1000',0);

#
# Structure for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Name` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `numLevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "users"
#

INSERT INTO `users` VALUES ('abc','123',1),('lszj','123',1),('root','456',0),('wrl','123',1);
