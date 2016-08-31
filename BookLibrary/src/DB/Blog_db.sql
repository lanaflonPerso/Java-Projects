-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Server version:               10.1.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Версия:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table blog2.books
CREATE TABLE IF NOT EXISTS `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about` longtext,
  `author` varchar(100) NOT NULL,
  `date_post` datetime NOT NULL,
  `title` varchar(200) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcykkh3hxh89ammmwch0gw5o1s` (`user_id`),
  KEY `FKleqa3hhc0uhfvurq6mil47xk0` (`category_id`),
  CONSTRAINT `FKcykkh3hxh89ammmwch0gw5o1s` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKleqa3hhc0uhfvurq6mil47xk0` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table blog2.books: ~0 rows (approximately)
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
/*!40000 ALTER TABLE `books` ENABLE KEYS */;


-- Dumping structure for table blog2.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about` longtext,
  `name` varchar(50) NOT NULL,
  `type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t8o6pivur7nn124jehx7cygw5` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table blog2.categories: ~4 rows (approximately)
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` (`id`, `about`, `name`, `type`) VALUES
	(5, 'Java', 'Java', 'Java'),
	(6, 'Data', 'Data', 'Data'),
	(7, 'Duel', 'Duel', 'Duel'),
	(8, 'Lifestyle', 'Lifestyle', 'Lifestyle');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;


-- Dumping structure for table blog2.comments_books
CREATE TABLE IF NOT EXISTS `comments_books` (
  `id_cmnt_book` bigint(20) NOT NULL,
  `title_comment` varchar(100) DEFAULT NULL,
  `date_post` datetime NOT NULL,
  `text_comment` varchar(500) DEFAULT NULL,
  `book_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FKtfwtdyx3fwgtkus8f1njd8x9m` (`book_id`),
  KEY `FKndsgj1qt2ss71yty12apd94im` (`user_id`),
  CONSTRAINT `FKndsgj1qt2ss71yty12apd94im` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKtfwtdyx3fwgtkus8f1njd8x9m` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table blog2.comments_books: ~0 rows (approximately)
/*!40000 ALTER TABLE `comments_books` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments_books` ENABLE KEYS */;


-- Dumping structure for table blog2.comments_events
CREATE TABLE IF NOT EXISTS `comments_events` (
  `id_cmnt_event` bigint(20) NOT NULL,
  `title_comment` varchar(100) DEFAULT NULL,
  `date_comment` datetime NOT NULL,
  `text_comment` varchar(500) DEFAULT NULL,
  `event_id_event` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FK6qbdse5lif2gyis2gh6ffflxf` (`user_id`),
  CONSTRAINT `FK6qbdse5lif2gyis2gh6ffflxf` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table blog2.comments_events: ~0 rows (approximately)
/*!40000 ALTER TABLE `comments_events` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments_events` ENABLE KEYS */;


-- Dumping structure for table blog2.comments_posts
CREATE TABLE IF NOT EXISTS `comments_posts` (
  `id_cmnt_post` bigint(20) NOT NULL AUTO_INCREMENT,
  `title_comment` varchar(100) DEFAULT NULL,
  `date_comment` datetime NOT NULL,
  `text_comment` varchar(500) DEFAULT NULL,
  `post_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_cmnt_post`),
  KEY `FKfyiffvnf6d6dvyr9p99yjmqrr` (`post_id`),
  KEY `FKt89vw7n04pg1ndgob6bgcli4f` (`user_id`),
  CONSTRAINT `FKfyiffvnf6d6dvyr9p99yjmqrr` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `FKt89vw7n04pg1ndgob6bgcli4f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

-- Dumping data for table blog2.comments_posts: ~28 rows (approximately)
/*!40000 ALTER TABLE `comments_posts` DISABLE KEYS */;
INSERT INTO `comments_posts` (`id_cmnt_post`, `title_comment`, `date_comment`, `text_comment`, `post_id`, `user_id`) VALUES
	(15, NULL, '2016-08-31 23:47:43', 'Excellent!', 10, 1),
	(16, NULL, '2016-08-31 23:48:02', 'Great article, it summarizes the integration of multiple key technologies in a way that is easy to explain even to Juniors.Congratulations sir!', 10, 2),
	(17, NULL, '2016-08-30 02:02:27', 'It would be great to add an issue tracking system such as Jira or Redmine. And also slack chatbots would be rough and ready.', 10, 2),
	(18, NULL, '2016-08-30 02:07:19', 'Enjoyed your article. Keep it up, mate!', 11, 2),
	(19, NULL, '2016-08-30 02:07:32', 'Great article. Thank you!', 11, 3),
	(20, NULL, '2016-08-30 02:08:50', 'What about Nativescript ? ;)', 12, 4),
	(21, NULL, '2016-08-30 02:09:21', 'Having used both Cordova and React-Native, what stands out is the markedly better performance of the React-Native apps. Much more responsive. As a user it\'s the difference between a frustrating experience and a pleasurable experience.', 12, 5),
	(22, NULL, '2016-08-30 02:09:33', 'One of the pitfalls of using the mobile OS\' native WebView is that it may not have all the features of a full web browser. Enter the Crosswalk Project. It uses the latest Chromium build and bundles the compiled browser with your web app. It has support for Apache Cordova.', 12, 4),
	(23, NULL, '2016-08-30 02:09:43', 'One question, the apps created with crosswalk must be way bigger since they have to embed chromium, do you known the size of a really simple app made with crosswalk vs phonegap?', 12, 2),
	(24, NULL, '2016-08-30 02:09:56', '\r\n\r\nI\'ve worked with PhoneGap 2.0 -> Ionic 2, I seen a lot of improvement with this community! + I\'ve a little bit idea in React Native too. & I\'m writing article phonegappro.com\r\n\r\nMy Suggestion: It\'s not about Ionic vs React Native\r\n\r\nEverything based on app requirement\r\n', 12, 3),
	(25, NULL, '2016-08-30 02:11:08', 'Author have used the term "co-cousing" 5 times in this article, which is the wrong term.\r\nIt\'s Coliving.\r\nAnd you can find over 100 spaces on https://coliving.com', 13, 2),
	(26, NULL, '2016-08-30 02:11:21', 'well Ctrl/CMD + F co-cousing and there\'s only 1 though...', 13, 2),
	(27, NULL, '2016-08-30 02:11:34', 'Awesome article. It will be consulted when preparing my Remote working chats. Thank you very much!', 13, 3),
	(28, NULL, '2016-08-30 02:11:44', 'Great article!\r\nI wasn\'t aware of the many downfalls of remote work, but you also addressed the solutions and I think it\'s amazing that there are that many start-ups jumping on these issues to keep remote work thriving. ', 13, 2),
	(29, NULL, '2016-08-30 02:11:57', 'I can\'t not to share this link here - TOPTAL WILL SHOW YOU HOW THE ULTIMATE COMPANY RETREAT LOOKS LIKE\r\nhttps://www.thesurfoffice.com/...', 13, 4),
	(30, NULL, '2016-08-30 02:12:37', 'Nice article, I still don\'t understand why others don\'t see the greatness in Groovy and Grails!', 14, 2),
	(31, NULL, '2016-08-30 02:12:47', 'Great article for someone who has never heard of the technology. Thanks!', 14, 3),
	(32, NULL, '2016-08-30 02:13:36', '\r\n\r\nAs of today, Hibernate doesn\'t support discriminator based multi-tenancy. Open JIRA ticket: https://hibernate.atlassian.ne...\r\n\r\nIs there any way other than using filters and with other hacks?\r\n', 15, 2),
	(33, NULL, '2016-08-30 02:13:47', 'Great article to help anyone get up to speed with multi tenancy issues. Just don\'t think that introduction of multi tenancy will solve all your scaling issues. Also keep in mind that not all your clients have same usage of your software so while some databases will be perfect and with great performances others can get under high load very quickly and introduce latency, dropping connections etc.', 15, 1),
	(34, NULL, '2016-08-30 02:13:58', '1. Cost of maintenance and infrastructure would skyrocket (imagine your application is running on ~10-15 instances with several services like RabbitMQ, Amazon SQS/SNS etc.)\r\n2. You just want to keep data isolated but there can still be a lot of things that are shared.', 15, 1),
	(35, NULL, '2016-08-30 02:14:15', 'Very good article, congratulations!', 15, 1),
	(36, NULL, '2016-08-30 02:14:58', 'Very good article, congratulations!', 15, 1),
	(37, NULL, '2016-08-30 03:00:14', 'Java in the cloud sounds super, man! :)', 14, 1),
	(38, NULL, '2016-08-30 03:04:23', 'Java in the cloud sounds super, man! :)', 14, 3),
	(39, NULL, '2016-08-30 03:05:55', 'Java in the cloud sounds super, man! :)', 14, 2),
	(40, NULL, '2016-08-30 03:06:35', 'Java in the cloud sounds super, man! :)', 14, 1);
/*!40000 ALTER TABLE `comments_posts` ENABLE KEYS */;


-- Dumping structure for table blog2.events
CREATE TABLE IF NOT EXISTS `events` (
  `idEvent` bigint(20) NOT NULL,
  `id_event` bigint(20) NOT NULL,
  `about_event` varchar(700) NOT NULL,
  `date` datetime NOT NULL,
  `date_event` varchar(100) NOT NULL,
  `name_event` varchar(100) NOT NULL,
  `place_event` varchar(100) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FKo6mla8j1p5bokt4dxrlmgwc28` (`category_id`),
  KEY `FKat8p3s7yjcp57lny4udqvqncq` (`user_id`),
  CONSTRAINT `FKat8p3s7yjcp57lny4udqvqncq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKo6mla8j1p5bokt4dxrlmgwc28` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table blog2.events: ~0 rows (approximately)
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
/*!40000 ALTER TABLE `events` ENABLE KEYS */;


-- Dumping structure for table blog2.posts
CREATE TABLE IF NOT EXISTS `posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body` longtext NOT NULL,
  `date` datetime NOT NULL,
  `title` varchar(300) NOT NULL,
  `author_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `visits` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6xvn0811tkyo3nfjk2xvqx6ns` (`author_id`),
  KEY `FKijnwr3brs8vaosl80jg9rp7uc` (`category_id`),
  CONSTRAINT `FK6xvn0811tkyo3nfjk2xvqx6ns` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKijnwr3brs8vaosl80jg9rp7uc` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Dumping data for table blog2.posts: ~7 rows (approximately)
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` (`id`, `body`, `date`, `title`, `author_id`, `category_id`, `visits`) VALUES
	(10, 'Year after year, we bear witness to the increasingly rapid evolution of the IT industry. It has now been more than two decades since the groundbreaking slogan ”Write once, run anywhere“ set a whole new level of expectation for the software development community. And here we are today, with a resulting, ever-expanding set of tools that have collectively taken Java development in particular, and software development in general, to a whole new universe of possibility.Methodologies such as Agile, DevOps, and Continuous Integration and Deployment – along with the evolution of microservices – have collectively boosted software development process productivity to a point where it is a pleasure to be developing software more than ever before.', '2016-08-28 19:39:43', 'Java in the Cloud - Continuous Integration Setup Tutorial', 3, 5, 36),
	(11, 'ToptalThere are many design tips out there that claim to be universal solutions for achieving high conversion rates. However, in this article, Toptal Freelance Designer Joel Lopez suggests avoiding these trends or fads and encourages us to instead thoughtfully collect data to inform the design of our products.Although some quick-fix design moves may achieve high conversion rates in a product’s early years, they don’t lend themselves to establishing long-term user trust. Joel argues that this trust is essential to keep users coming back to promote your products.', '2016-08-28 19:37:19', 'Usability for Conversion: Stop Using Fads, Start Using Data', 4, 6, 23),
	(12, 'ToptalAs a result of smartphones and mobile applications becoming so popular, web developers have been looking for ways to create mobile applications using JavaScript. This increased demand has led to the development of many JavaScript frameworks capable of running native-like applications on mobile devices.In this article, Toptal Freelance Software Engineer Johannes Stein compares the current two most popular choices for mobile-oriented JavaScript frameworks, Cordova and React Native. Examining their advantages and pitfalls, he dives into details of each and compares them across different disciplines.', '2016-08-28 19:32:13', 'The Duel: React Native vs. Cordova', 2, 7, 11),
	(13, 'An often mentioned virtue of remote work is the freedom for individuals to construct their lifestyles as they wish. However, much of contemporary society has not yet shifted to allow for the total freedom that many desire, especially when it comes to housing. Why should outdated housing standards prevent us from living in the way we want to live?\r\n\r\nIn this article, Toptal Technical Editor Kent Mundle surveys a group of housing alternatives that apply to several different types of remote workers. The digital nomad has different needs than the young professional or the working parent, and their housing options should reflect that.', '2016-08-28 19:03:35', 'Alternative Housing Lifestyles for Remote Workers', 3, 8, 9),
	(14, 'Java may have stood the test of time, but it can still be a source of great frustration among many web developers. Dealing with its verbosity and infrastructure overhead, for example, can take hours, even for the most basic needs.\r\n\r\nIn this article, Toptal Freelance Software Engineer Gregor Ambrozic shows us how Grails and its many appealing features can be a viable alternative to traditional Java web applications frameworks.', '2016-08-28 19:38:29', 'Why Should Java Developers Give Grails a Chance?', 4, 5, 14),
	(15, 'In the realm of enterprise software, especially for software provided as a service, multitenancy ensures that data is truly isolated for each client within a shared instance of software. Among its numerous benefits, multitenancy can greatly simplify release management and cut down costs.\r\n\r\nIn this article, Toptal Freelance Software Engineer André William Prade Hildinger shows us how Hibernate, a persistence framework for Java, makes implementing a multitenant Java EE application easier than it sounds.', '2016-08-28 19:41:10', 'How to Build a Multitenant Application: A Hibernate Tutorial', 1, 5, 27),
	(16, 'Of all the modern ways people talk to each other, email seems to have stood the test of time and is arguably still one of the most effective and widely used means of communication. Thus, being able to programmatically send and receive emails can open new dimensions to a user’s experience of software that powers human communication.\r\n\r\nIn this article, Toptal Freelance Software Engineer Francis Altomare shows us how he leveraged various Amazon Web Services technologies to build a simple communication application in which email itself is an important interface.', '2016-08-29 21:20:26', 'A New Way of Using Email for Support Apps: An AWS Tutorial', 2, 6, 3);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;


-- Dumping structure for table blog2.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `FK97mxvrajhkq19dmvboprimeg1` (`user_id`),
  CONSTRAINT `FK97mxvrajhkq19dmvboprimeg1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table blog2.roles: ~2 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`role_id`, `role_name`, `user_id`) VALUES
	(1, 'Admin', 1),
	(2, 'User', 2);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Dumping structure for table blog2.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) DEFAULT NULL,
  `password_hash` varchar(60) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `date` datetime NOT NULL,
  `email` varchar(100) NOT NULL,
  `picturelink` varchar(100) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table blog2.users: ~5 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `fullname`, `password_hash`, `username`, `date`, `email`, `picturelink`, `role`) VALUES
	(1, 'Hristo Skipernov', '$2a$10$WCkX.TXDKKCAojQkzYAcsOFrKA9Il/9OOm.X5JN/24VKoBx0JXplW', 'ico', '2016-08-27 21:53:47', 'ico@abv.bg', NULL, 'Admin'),
	(2, 'Kremena Skipernova', '$2a$10$nZggfDw7kmQOlx1lCFM3gecChy43yIpddXV.8nA6LN28MEjR6VPjW', 'kremy', '2016-08-27 21:56:19', 'kremy@yahoo.com', NULL, 'User'),
	(3, 'Iordan Skipernov', '$2a$10$jMtAufViOPvHZ1y0QTHEweYAbmq3pP/UmbBpUWcIcL/GExvUtk7HS', 'dani', '2016-08-28 17:01:37', 'dani@abv.bg', NULL, 'User'),
	(4, 'Alexandr Skipernov', '$2a$10$b6/FLGFqLmw5N2NxCXLfr.2yJqVs0kx/WvIOsOkiJz85/TEJbTI9m', 'sasho', '2016-08-28 18:51:09', 'sash@gmail.com', NULL, 'User'),
	(5, 'Vencislav Pavlov', '$2a$10$RzNvCj0hr2C0MmcU7ZoN1e59AUE5pbtpSuCcB0LKVpu9ZGhtFp/UW', 'venci', '2016-08-28 19:52:39', 'venc@abv.bg', NULL, 'User'),
	(6, 'Atanas Panaiotov', '$2a$10$cKyALfe39wfdVkqpdgxDJ.O.Ua8j0TfglIWWYV7RC0kYxfvd6vDFm', 'nasko', '2016-09-01 01:45:21', 'nasko@gmail.com', NULL, 'User'),
	(7, 'Martin Atanasov', '$2a$10$ExAZ.g.k6CgOjDtkuXQMOuVVHwKcXuKJj5gKpkEHjhixeMig1vFoi', 'chomaka', '2016-09-01 01:45:57', 'chomaka@abv.bg', NULL, 'User'),
	(8, 'Nikolay Kasakov', '$2a$10$SXC8TYjIZBbK7ITZUYKY4O8i7KLGb9iwdBK17crnxOFUPqSrxeAIy', 'niki', '2016-09-01 01:46:28', 'niki@yahoo.com', NULL, 'User');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
