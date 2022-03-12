/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : video

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 12/03/2022 15:00:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `video_id` int(0) NOT NULL,
  UNIQUE INDEX `unique_video_id`(`video_id`) USING BTREE,
  CONSTRAINT `banner` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (1);
INSERT INTO `banner` VALUES (2);
INSERT INTO `banner` VALUES (3);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '视频分类id',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `category_name`(`category_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'java');
INSERT INTO `category` VALUES (10, '内地');
INSERT INTO `category` VALUES (12, '剧情');
INSERT INTO `category` VALUES (8, '动作');
INSERT INTO `category` VALUES (5, '华语');
INSERT INTO `category` VALUES (4, '历史');
INSERT INTO `category` VALUES (7, '喜剧');
INSERT INTO `category` VALUES (9, '奇幻');
INSERT INTO `category` VALUES (6, '战争');
INSERT INTO `category` VALUES (2, '武侠');
INSERT INTO `category` VALUES (13, '院线');
INSERT INTO `category` VALUES (3, '青春校园');
INSERT INTO `category` VALUES (11, '革命');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_authority` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `role_authority`(`role_authority`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '用户管理', 'user');
INSERT INTO `role` VALUES (2, '视频管理', 'video');
INSERT INTO `role` VALUES (3, '视频分类管理', 'category');
INSERT INTO `role` VALUES (4, '权限管理', 'role');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `type_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名：如电影',
  PRIMARY KEY (`type_id`) USING BTREE,
  UNIQUE INDEX `type_name`(`type_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (3, '动漫');
INSERT INTO `type` VALUES (1, '电影');
INSERT INTO `type` VALUES (2, '电视剧');
INSERT INTO `type` VALUES (4, '综艺');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `password` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `email` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `register_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(0) NOT NULL COMMENT '用户角色状态',
  `telephone` int(0) NULL DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '1355083406@qq.com', '2022-02-08 15:07:40', NULL, 1, NULL);
INSERT INTO `user` VALUES (21, 'admi', '123', NULL, '2022-02-08 15:20:59', NULL, 0, NULL);
INSERT INTO `user` VALUES (22, 'ads', '123', NULL, '2022-02-08 15:22:51', NULL, 0, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(0) NOT NULL,
  `role_id` int(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (1, 2);
INSERT INTO `user_role` VALUES (1, 3);
INSERT INTO `user_role` VALUES (1, 4);
INSERT INTO `user_role` VALUES (2, 1);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `video_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `user_id` int(0) NOT NULL COMMENT '用户id',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频封面地址',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频标题/名称',
  `region` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `create_time` year NULL DEFAULT NULL COMMENT '上映时间年份',
  `upload_time` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '视频内容',
  `director` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '导演',
  `type` int(0) NULL DEFAULT NULL COMMENT '类别，比如电影',
  `score` float NULL DEFAULT NULL COMMENT '豆瓣评分，如2.9分',
  `count` int(0) NULL DEFAULT NULL COMMENT '点击量',
  PRIMARY KEY (`video_id`) USING BTREE,
  UNIQUE INDEX `unique_title`(`title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, 1, 'https://puui.qpic.cn/vcover_vt_pic/0/mzc00200nx1hbcr1640263452900/260', '长津湖', '中国', 2021, '2022-02-09 10:40:53', '以抗美援朝战争第二次战役中的长津湖战役为背景，讲述了一段波澜壮阔的历史：71年前，中国人民志愿军赴朝作战，在极寒严酷环境下，东线作战部队凭着钢铁意志和英勇无畏的战斗精神一路追击，奋勇杀敌，扭转了战场态势，打出了军威国威。', ' 陈凯歌 徐克 林超贤', 1, 7.4, NULL);
INSERT INTO `video` VALUES (2, 1, 'https://movie.douban.com/subject/35505100/photos?type=R', '这个杀手不太冷静', '中国', 2022, '2022-02-09 11:34:02', '毕生追求男主梦的魏成功（魏翔 饰）终于得到了女明星米兰（马丽 饰）的“赏识”，被邀请出演她的男一号“杀手卡尔”，他兴致勃勃诠释角色的同时，却没想到已经落入了一场危机四伏的阴谋，但他依然借自己 “精湛”的演技和绝佳的运气化险为夷，而残酷的真相也离他越来越近……', '邢文雄', 1, 6.5, NULL);
INSERT INTO `video` VALUES (3, 1, 'https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2575362797.webp', '庆余年 第一季', '中国', 2019, '2022-02-21 20:36:51', '某大学文学史专业的学生张庆熟读古典名著，但他用现代观念剖析古代文学史的论文命题不被叶教授所认可。为了让叶教授成为自己的研究生导师，张庆决定通过写小说的方式，进一步阐述自己想要表达的观点。\r\n　　在他的小说中，身世神秘的少年——范闲，自小跟随奶奶生活在海边小城澹州，随着一位老师的突然造访，他看似平静的生活开始直面重重的危机与考验。在神秘老师和一位蒙眼守护者的指点下，范闲熟识药性药理，修炼霸道真气并精进武艺，而后接连化解了诸多危局。因对身世之谜的好奇，范闲离开澹州，前赴京都。\r\n　　在京都，范闲凭借过人的智谋与勇武成为年轻一代的佼佼者，他先以诗文冠绝京都，而后出使邻国，营救人质，整合谍报网，查处震动朝野的走私案……这个过程中，范闲饱尝人间冷暖并坚守对正义、良善的坚持，历经家族、江湖、庙堂的种种考验与锤炼，书写了光彩的人生传奇。', '孙皓', 2, 7.9, NULL);

-- ----------------------------
-- Table structure for video_category
-- ----------------------------
DROP TABLE IF EXISTS `video_category`;
CREATE TABLE `video_category`  (
  `video_id` int(0) NOT NULL COMMENT '视频id',
  `category_id` int(0) NOT NULL COMMENT '分类id',
  INDEX `video_id`(`video_id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `video_id` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_category
-- ----------------------------
INSERT INTO `video_category` VALUES (1, 4);
INSERT INTO `video_category` VALUES (1, 10);
INSERT INTO `video_category` VALUES (1, 6);
INSERT INTO `video_category` VALUES (1, 11);
INSERT INTO `video_category` VALUES (1, 12);
INSERT INTO `video_category` VALUES (1, 13);
INSERT INTO `video_category` VALUES (2, 4);

-- ----------------------------
-- Table structure for video_type
-- ----------------------------
DROP TABLE IF EXISTS `video_type`;
CREATE TABLE `video_type`  (
  `video_id` int(0) NOT NULL COMMENT '视频id',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频地址',
  `sets` int(0) NULL DEFAULT NULL COMMENT '集数：如第1,2级',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '每一集描述',
  UNIQUE INDEX `unique_video_type_sets`(`sets`) USING BTREE,
  INDEX `video_id_type`(`video_id`) USING BTREE,
  CONSTRAINT `video_id_type` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_type
-- ----------------------------
INSERT INTO `video_type` VALUES (1, 'http://video.daqian.shop/%E9%95%BF%E6%B4%A5%E6%B9%96.mp4', NULL, 'HD');
INSERT INTO `video_type` VALUES (3, '庆余年第一集视频地址', 1, '庆余年第一集');
INSERT INTO `video_type` VALUES (3, '庆余年第二集视频地址', 2, '庆余年第二集');
INSERT INTO `video_type` VALUES (3, '庆余年第三集视频地址', 3, '更新至第三集');
INSERT INTO `video_type` VALUES (2, '这个杀手不太冷静地址', NULL, 'HD');

SET FOREIGN_KEY_CHECKS = 1;
