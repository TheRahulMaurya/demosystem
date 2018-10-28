


INSERT INTO `demo_system`.`device` (`device_id`, `description`, `status`) VALUES ('1', 'Neoport', 'Working');
INSERT INTO `demo_system`.`device` (`device_id`, `description`, `status`) VALUES ('2', 'FYVE S1', 'Working');
INSERT INTO `demo_system`.`device` (`device_id`, `description`, `status`) VALUES ('3', 'Spirometer', 'Idle');



INSERT INTO `demo_system`.`protocol` (`protocol_id`, `created_on`, `effective_date`, `title`, `device_id`) VALUES ('1', '2016-01-01 00:00:01', '2015-01-01 00:00:01', 'prot1', '1');
INSERT INTO `demo_system`.`protocol` (`protocol_id`, `created_on`, `effective_date`, `title`, `device_id`) VALUES ('2', '2017-01-01 00:00:01', '2016-01-01 00:00:01', 'prot2', '1');
INSERT INTO `demo_system`.`protocol` (`protocol_id`, `created_on`, `effective_date`, `title`) VALUES ('3', '2018-01-01 00:00:01', '2019-01-01 00:00:01', 'prot3');


INSERT INTO `demo_system`.`user` (`user_id`, `email`, `user_name`, `tag_id`) VALUES ('1', 'aaa@gmail.com', 'Rahul', '2');
INSERT INTO `demo_system`.`user` (`user_id`, `email`, `user_name`, `tag_id`) VALUES ('2', 'bbb@gmail.com', 'Ravi', '1');
INSERT INTO `demo_system`.`user` (`user_id`, `email`, `user_name`, `tag_id`) VALUES ('3', 'ccc@gmail.com', 'Kamal', '3');



INSERT INTO `demo_system`.`tag` (`tag_id`, `created_on`, `description`, `is_active`) VALUES ('1', '2016-01-01 00:00:01', 'Operator', 'Y');
INSERT INTO `demo_system`.`tag` (`tag_id`, `created_on`, `description`, `is_active`) VALUES ('2', '2016-01-01 00:00:01', 'Admin', 'N');
INSERT INTO `demo_system`.`tag` (`tag_id`, `created_on`, `description`, `is_active`) VALUES ('3', '2016-01-01 00:00:01', 'Manager', 'Y');


INSERT INTO `demo_system`.`device_user_map` VALUES (1,1);
INSERT INTO `demo_system`.`device_user_map` VALUES (2,1);