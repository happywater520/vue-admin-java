# Host: localhost  (Version: 5.7.26)
# Date: 2023-04-10 15:09:37
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) DEFAULT NULL,
  `admin_username` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "admin"
#

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (3,'admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

#
# Structure for table "class"
#

DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "class"
#

/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,1,'计算机网络','西3-202'),(2,2,'英语','L509'),(3,3,'社会科学','D101'),(4,4,'认知科学','西1-201'),(5,5,'人工智能','L508'),(6,1,'操作系统','东3-202');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;

#
# Structure for table "class_score"
#

DROP TABLE IF EXISTS `class_score`;
CREATE TABLE `class_score` (
  `id` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "class_score"
#

/*!40000 ALTER TABLE `class_score` DISABLE KEYS */;
INSERT INTO `class_score` VALUES (NULL,85,1,2,'2023-04-10 14:43:09',0,'开学考'),(NULL,80,2,1,'2023-04-10 14:21:04',1,'期末考'),(NULL,80,1,1,'2023-04-10 14:30:25',0,'开学考'),(NULL,80,2,1,'2023-04-10 14:30:40',0,'开学考'),(NULL,80,1,1,'2023-04-10 14:30:46',1,'期末考'),(NULL,80,3,1,'2023-04-10 14:30:58',0,'开学考'),(NULL,80,4,1,'2023-04-10 14:31:04',0,'开学考'),(NULL,80,5,1,'2023-04-10 14:31:12',0,'开学考'),(NULL,80,1,2,'2023-04-10 14:43:21',1,'期末考'),(NULL,67,2,2,'2023-04-10 14:43:32',0,'开学考'),(NULL,68,3,2,'2023-04-10 14:43:42',0,'开学考'),(NULL,98,4,2,'2023-04-10 14:44:04',0,'开学考'),(NULL,66,5,2,'2023-04-10 14:44:13',0,'开学考');
/*!40000 ALTER TABLE `class_score` ENABLE KEYS */;

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) DEFAULT NULL,
  `student_number` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `student_password` varchar(255) DEFAULT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `student_sex` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'2005020220','黎阳春','lyc','1',1),(2,'2005020200','林汐','lx','1',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

#
# Structure for table "student_class"
#

DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class` (
  `id` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `class_id` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "student_class"
#

/*!40000 ALTER TABLE `student_class` DISABLE KEYS */;
INSERT INTO `student_class` VALUES ('1645310957530845185','1','2'),('1645313177278156801','1','1'),('1645313186342047746','1','3'),('1645313188443394049','1','4'),('1645313553796632578','1','5'),('1645316344925589505','2','1'),('1645316348708851713','2','2'),('1645316350889889793','2','3'),('1645316352605360130','2','4'),('1645316354262110209','2','5');
/*!40000 ALTER TABLE `student_class` ENABLE KEYS */;

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) DEFAULT NULL,
  `teacher_number` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher_password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "teacher"
#

/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'001','李一','lls'),(2,'002','赵二','zls'),(3,'003','徐三','xls'),(4,'004','黄四','hls'),(5,'005','张五','zls');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
