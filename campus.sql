/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-25 18:13:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '关注索引',
  `user_id` int(12) NOT NULL COMMENT '用户索引id',
  `focused_id` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '被关注者的索引id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of focus
-- ----------------------------
INSERT INTO `focus` VALUES ('1', '3', '1;2;');
INSERT INTO `focus` VALUES ('4', '2', '3;');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `post_user_id` int(40) NOT NULL COMMENT '发帖用户的索引id',
  `post_user_name` varchar(12) COLLATE utf8_bin NOT NULL COMMENT '发帖id',
  `post_title` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '帖子标题',
  `post_tab_id` int(20) NOT NULL COMMENT '帖子标签(分类)',
  `post_tab_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '帖子标签名',
  `tab_parentid` int(10) unsigned NOT NULL COMMENT '帖子标签的父标签名',
  `post_content` varchar(1000) COLLATE utf8_bin NOT NULL COMMENT '帖子内容',
  `post_time` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '发帖时间 ',
  `post_content_img` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '发帖附带的图片',
  `post_user_icon` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '发帖人照片',
  `post_click_count` int(10) DEFAULT '0' COMMENT '帖子点击数',
  `post_reply_count` int(10) unsigned DEFAULT '0' COMMENT '帖子回复数',
  `post_last_reply` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '帖子最后回复者',
  `post_last_reply_time` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '帖子最后回复时间',
  `post_last_reply_time_simple` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '帖子最后回复时间(差值)用来显示在页面上',
  PRIMARY KEY (`id`),
  KEY `userid` (`post_user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '2', '吹不散眉弯', '找找一份实习工作', '14', '实习', '2', '本人软件学院的一名15级学生，想要找一份软件工程,java方向的工作，有没有大佬能够帮我引荐一下，或者推荐一下工作什么的啊，非常感谢啊。', '2019-03-29 10:34:51', '226ce810-c32d-4ce5-993f-3986ee9aad06.PNG', '', '102', '0', '', '', '');
INSERT INTO `post` VALUES ('2', '2', '吹不散眉弯', '今天学到了一点新的东西，跟同学们分享一下', '9', '工学', '1', '今天学习了设计模式，发现里面很多东西都非常值得思考，今天刚刚学习了策略模式，感觉非常不错，希望大家都可以学习一下，', '2019-03-29 10:38:08', '51d89138-372b-42e7-91c9-78afef1c52a3.PNG', '', '298', '7', '一首歌从深情唱', '2019-04-23 13:41:04', '2天4小时30分钟之前');
INSERT INTO `post` VALUES ('3', '2', '吹不散眉弯', '谈谈今天的一些感受吧', '9', '工学', '1', '今天温度挺低的，本来就穿的不厚，结果感觉今天脑子更疼， 不知道大家有没有啥推荐的网站听听音乐啥的吗,http://www.baidu.com', '2019-04-01 09:07:44', 'ab35664c-3d1d-4046-98de-5e3de09ce992.PNG', '', '46', '2', '一首歌从深情唱', '2019-04-08 18:06:20', '17天0小时5分钟之前');
INSERT INTO `post` VALUES ('4', '1', 'root', 'B 站的同学，你们能不能不要在移动端主页投毒了？', '10', '理学', '1', '每次手机重装系统之后去 B 站主页( https://m.bilibili.com/index.html) 下客户端，都会下到国际版。只能安装客户端后去问客服要国内的客户端，再重新装一次。​为什么移动端首页不能改成国内的？国际版的没有免流服务，我要它何用？', '2019-04-01 09:09:08', '', '', '40', '2', '吹不散眉弯', '2019-04-09 09:08:22', '16天9小时3分钟之前');
INSERT INTO `post` VALUES ('5', '2', '吹不散眉弯', '测试下管理学代码', '12', '管理学', '1', '如果管理学代码测试成功！，那么今天就完成了很大的一部分工作！加油 2019/4/1', '2019-04-01 11:27:28', '', null, '112', '1', '一首歌从深情唱', '2019-04-04 14:27:28', '21天3小时44分钟之前');
INSERT INTO `post` VALUES ('6', '2', '吹不散眉弯', '理学的二次测试', '10', '理学', '1', '如果这次理学测试成功，那么真的一二级标题联动就正式写完了！', '2019-04-01 16:09:43', '', null, '52', '5', 'root', '2019-04-08 16:09:43', '17天2小时2分钟之前');
INSERT INTO `post` VALUES ('7', '1', 'root', 'ajax出问题了', '16', '全职', '2', '后台我将两个list放到了一个map里，但是问题是我想把其中一个list的值渲染到前台的某个div中，因为那个div本身就已经是个list循环出来的(是上一个页面点击渲染的)，但是ajax返回之后 我不知道 应该怎么写下面是前台的代码:(这个list本来是有值的 )', '2019-04-09 14:00:01', '', null, '28', '1', '吹不散眉弯', '2019-04-09 15:10:06', '10天1小时47分钟之前');
INSERT INTO `post` VALUES ('8', '1', 'root', '有河南老乡在深圳实习吗？', '30', '华中天地', '5', '题主现在在深圳，想看看有没有校友啊，有空一起玩，一起交流，一起学习啊..', '2019-04-19 17:02:26', '', null, '6', '1', '一首歌从深情唱', '2019-04-19 17:03:37', '4天16小时43分钟之前');
INSERT INTO `post` VALUES ('9', '3', '一首歌从深情唱', '软件学院实验室招新', '41', '软件学院', '8', '软件学院303实验室招新，具体的详情，可以去303实验室查看，获取去302找老师咨询，欢迎各位！', '2019-04-22 14:50:54', '', null, '32', '7', '一首歌从深情唱', '2019-04-24 09:36:35', '1天4小时3分钟之前');

-- ----------------------------
-- Table structure for postcollection
-- ----------------------------
DROP TABLE IF EXISTS `postcollection`;
CREATE TABLE `postcollection` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '收藏帖子索引',
  `user_id` varchar(12) COLLATE utf8_bin NOT NULL COMMENT '收藏者id',
  `post_id` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '帖子索引id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of postcollection
-- ----------------------------
INSERT INTO `postcollection` VALUES ('1', '3', '4;7;8');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '回复id',
  `post_id` int(20) NOT NULL COMMENT '帖子id',
  `reply_user_id` int(40) DEFAULT NULL COMMENT '回复者索引Id',
  `reply_user_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '回复者用户名',
  `reply_content` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '回复内容',
  `reply_time` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '回复时间',
  `reply_floor` int(10) unsigned NOT NULL COMMENT '回复层数',
  `reply_time_simple` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '回复时间简写',
  PRIMARY KEY (`id`),
  KEY `postid` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '6', '2', '吹不散眉弯', '我感觉这次测试会成功!', '2019-04-02 17:11:30', '1', '22天22小时5分钟之前');
INSERT INTO `reply` VALUES ('2', '6', '2', '吹不散眉弯', '这测试的第二条回复 看看会不会成功', '2019-04-02 17:39:52', '2', '22天21小时37分钟之前');
INSERT INTO `reply` VALUES ('3', '6', '2', '吹不散眉弯', '现在进行第三条回复测试', '2019-04-02 18:04:21', '3', '22天21小时12分钟之前');
INSERT INTO `reply` VALUES ('4', '6', '2', '吹不散眉弯', '第四次测试看看到底哪里有问题', '2019-04-02 18:07:16', '4', '22天21小时9分钟之前');
INSERT INTO `reply` VALUES ('5', '6', '2', '吹不散眉弯', '第五次测试！，这次一定要成功啊！', '2019-04-02 18:10:02', '5', '22天21小时7分钟之前');
INSERT INTO `reply` VALUES ('6', '2', '1', 'root', '那本书我也看了，我打算明天再看一遍', '2019-04-08 14:40:15', '1', '17天2小时7分钟之前');
INSERT INTO `reply` VALUES ('7', '2', '1', 'root', '那本书我也看了，我打算明天再看一遍', '2019-04-08 14:41:05', '2', '17天2小时6分钟之前');
INSERT INTO `reply` VALUES ('8', '3', '3', '一首歌从深情唱', '歌曲的话，可以去51sing里面好像还有伴奏可以随便下，感觉挺不错的，你可以去试试啊，然后我现在平常用QQ音乐听，自己用的大王卡，感觉用QQ音乐听非常好', '2019-04-08 15:33:01', '1', '16天23小时54分钟之前');
INSERT INTO `reply` VALUES ('9', '5', '3', '一首歌从深情唱', '哈哈，测试差不多可以结束了，真正的实现了相应的功能操作，和应有的逻辑，不负初心，不负己！', '2019-04-08 15:35:53', '1', '17天2小时36分钟之前');
INSERT INTO `reply` VALUES ('10', '2', '3', '一首歌从深情唱', '现在测试一下时间的更新看看对不对', '2019-04-08 16:54:52', '3', '16天23小时52分钟之前');
INSERT INTO `reply` VALUES ('11', '2', '3', '一首歌从深情唱', '我来更新一下时间，看看时间对不对', '2019-04-08 17:27:07', '3', '16天23小时20分钟之前');
INSERT INTO `reply` VALUES ('12', '3', '3', '一首歌从深情唱', '现在来测试一下时间差值是否正确！', '2019-04-08 18:06:20', '2', '16天21小时20分钟之前');
INSERT INTO `reply` VALUES ('13', '4', '3', '一首歌从深情唱', '真是个悲伤的故事，时间测试还是没有完全成功！', '2019-04-08 18:16:30', '1', '16天21小时0分钟之前');
INSERT INTO `reply` VALUES ('14', '4', '2', '吹不散眉弯', '我感觉如果真的可能的话，或许我们可以调整一下思路，重新把时间好好划分一下，这样的话应该就不会有太大问题', '2019-04-09 09:08:22', '2', '16天6小时8分钟之前');
INSERT INTO `reply` VALUES ('15', '2', '2', '吹不散眉弯', '就奇怪不知道为啥感觉效率很慢呢，', '2019-04-09 09:18:06', '4', '16天7小时29分钟之前');
INSERT INTO `reply` VALUES ('16', '2', '1', 'root', '测试', '2019-04-09 09:53:51', '5', '16天6小时53分钟之前');
INSERT INTO `reply` VALUES ('17', '2', '1', 'root', '测试下时间是否是正确的', '2019-04-09 09:55:55', '6', '16天6小时51分钟之前');
INSERT INTO `reply` VALUES ('18', '7', '2', '吹不散眉弯', '测试一下距离！', '2019-04-09 15:10:06', '1', '10天1小时47分钟之前');
INSERT INTO `reply` VALUES ('19', '8', '3', '一首歌从深情唱', '有啊，我就在深圳，现在在龙岗区，你在哪个区呢，有空可以见个面啊，，哈哈~', '2019-04-19 17:03:37', '1', '3天20小时45分钟之前');
INSERT INTO `reply` VALUES ('20', '9', '1', 'root', '今天下午去，老师不在办公室，明天再去看一下', '2019-04-22 15:57:04', '1', '2天22小时48分钟之前');
INSERT INTO `reply` VALUES ('21', '9', '3', '一首歌从深情唱', '', '2019-04-23 11:28:48', '2', '2天3小时17分钟之前');
INSERT INTO `reply` VALUES ('22', '9', '3', '一首歌从深情唱', '', '2019-04-23 11:35:19', '3', '2天3小时10分钟之前');
INSERT INTO `reply` VALUES ('23', '9', '3', '一首歌从深情唱', '', '2019-04-23 11:37:20', '4', '2天3小时8分钟之前');
INSERT INTO `reply` VALUES ('24', '9', '3', '一首歌从深情唱', '', '2019-04-23 11:47:39', '5', '2天2小时58分钟之前');
INSERT INTO `reply` VALUES ('25', '9', '3', '一首歌从深情唱', '', '2019-04-23 11:51:37', '6', '2天2小时54分钟之前');
INSERT INTO `reply` VALUES ('26', '2', '3', '一首歌从深情唱', '测试一下，回复为空和不为空的区别', '2019-04-23 13:41:04', '7', '2天3小时6分钟之前');
INSERT INTO `reply` VALUES ('27', '9', '3', '一首歌从深情唱', '今天再去看一眼，看看老师在不在办公室~', '2019-04-24 09:36:35', '7', '1天5小时9分钟之前');

-- ----------------------------
-- Table structure for tab
-- ----------------------------
DROP TABLE IF EXISTS `tab`;
CREATE TABLE `tab` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `tab_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '标签名',
  `parent_id` int(20) NOT NULL COMMENT '父标签id',
  `tab_describe` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '标签简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tab
-- ----------------------------
INSERT INTO `tab` VALUES ('1', '学霸', '0', '0');
INSERT INTO `tab` VALUES ('2', '酷工作', '0', '0');
INSERT INTO `tab` VALUES ('3', '娱乐畅享', '0', '0');
INSERT INTO `tab` VALUES ('4', '知性感性', '0', '0');
INSERT INTO `tab` VALUES ('5', '乡情友谊', '0', '0');
INSERT INTO `tab` VALUES ('6', '失物招领', '0', '0');
INSERT INTO `tab` VALUES ('7', '二手交易', '0', '0');
INSERT INTO `tab` VALUES ('8', '学院分区', '0', '0');
INSERT INTO `tab` VALUES ('9', '工学', '1', '分享你的工学生活');
INSERT INTO `tab` VALUES ('10', '理学', '1', '分享你的理学生活');
INSERT INTO `tab` VALUES ('11', '法学', '1', '分享你的法学生活');
INSERT INTO `tab` VALUES ('12', '管理学', '1', '分享你的管理学生活');
INSERT INTO `tab` VALUES ('13', '教育学', '1', '分享你的教育学生活');
INSERT INTO `tab` VALUES ('14', '实习', '2', '发布实习&&寻找实习');
INSERT INTO `tab` VALUES ('15', '兼职', '2', '发布兼职&&寻找兼职');
INSERT INTO `tab` VALUES ('16', '全职', '2', '发布全职&&寻找全职');
INSERT INTO `tab` VALUES ('17', 'Geek', '3', '我是Geek，我为自己代言');
INSERT INTO `tab` VALUES ('18', '游戏天地', '3', '游戏虽好，可别贪时');
INSERT INTO `tab` VALUES ('19', '动漫天地', '3', '二次元，三次元，萌即是王道');
INSERT INTO `tab` VALUES ('20', '美食天地', '3', '做一个吃货，是这辈子最幸福的事');
INSERT INTO `tab` VALUES ('21', '旅行分享', '3', '成为背包客，带你看世界');
INSERT INTO `tab` VALUES ('22', '笑口常开', '3', '笑口常开，好彩自然来');
INSERT INTO `tab` VALUES ('23', '流行歌坛', '3', '初闻不知曲中意，再听已是曲中人');
INSERT INTO `tab` VALUES ('24', '鹊桥', '4', '在天愿作比翼鸟，在地愿做连理枝');
INSERT INTO `tab` VALUES ('25', '别问我是谁', '4', '说说秘密吧');
INSERT INTO `tab` VALUES ('26', '谈情说爱', '4', '分享感情，共同成长');
INSERT INTO `tab` VALUES ('27', '梦之彼岸', '4', '每个人都是大梦想家');
INSERT INTO `tab` VALUES ('28', '男孩子', '4', '属于男孩子的小天堂，女孩子勉强进来吧');
INSERT INTO `tab` VALUES ('29', '女孩子', '4', '属于女孩子的小天堂，男孩子勉强进来吧');
INSERT INTO `tab` VALUES ('30', '华中天地', '5', '我来自华中');
INSERT INTO `tab` VALUES ('31', '华南风采', '5', '我来自华南');
INSERT INTO `tab` VALUES ('32', '华东风情', '5', '我来自华东');
INSERT INTO `tab` VALUES ('33', '华北风韵', '5', '我来自华北');
INSERT INTO `tab` VALUES ('34', '西南美景', '5', '我来自西南');
INSERT INTO `tab` VALUES ('35', '西北风光', '5', '我来自西北');
INSERT INTO `tab` VALUES ('36', '东北豪情', '5', '我来自东北');
INSERT INTO `tab` VALUES ('37', '不慎丢失', '6', '不小心丢掉了个重要的东西');
INSERT INTO `tab` VALUES ('38', '刚好碰到', '6', '有幸捡到了这个重要的东西');
INSERT INTO `tab` VALUES ('39', '我想买', '7', '我想淘点好东东');
INSERT INTO `tab` VALUES ('40', '我想卖', '7', '我想忍痛卖点货');
INSERT INTO `tab` VALUES ('41', '软件学院', '8', '软件学院事务通知');
INSERT INTO `tab` VALUES ('42', '政法学院', '8', '政法学院事务通知');
INSERT INTO `tab` VALUES ('43', '体育学院', '8', '体育学院事务通知');
INSERT INTO `tab` VALUES ('44', '外国语学院', '8', '外国语学院事务通知');
INSERT INTO `tab` VALUES ('45', '艺术设计学院', '8', '艺术设计学院事务通知');
INSERT INTO `tab` VALUES ('46', '机电工程学院', '8', '机电工程学院事务通知');
INSERT INTO `tab` VALUES ('47', '国际教育学院', '8', '国际教育学院事务通知');
INSERT INTO `tab` VALUES ('48', '继续教育学院', '8', '继续教育学院事务通知');
INSERT INTO `tab` VALUES ('49', '马克思主义学院', '8', '马克思主义学院事务通知');
INSERT INTO `tab` VALUES ('50', '经济与管理学院', '8', '经济与管理学院事务通知');
INSERT INTO `tab` VALUES ('51', '电子信息工程学院', '8', '电子信息工程学院事务通知');
INSERT INTO `tab` VALUES ('52', '电气信息工程学院', '8', '电气信息工程学院事务通知');
INSERT INTO `tab` VALUES ('53', '建筑环境工程学院', '8', '建筑环境工程学院事务通知');
INSERT INTO `tab` VALUES ('54', '数学与信息科学学院', '8', '数学与信息科学学院事务通知');
INSERT INTO `tab` VALUES ('55', '能源与动力工程学院', '8', '能源与动力学院事务通知');
INSERT INTO `tab` VALUES ('56', '食品与生物工程学院', '8', '食品与生物工程学院事务通知');
INSERT INTO `tab` VALUES ('57', '烟草科学与工程学院', '8', '烟草科学与工程学院事务通知');
INSERT INTO `tab` VALUES ('58', '物理与电子工程学院', '8', '物理与电子工程学院事务通知');
INSERT INTO `tab` VALUES ('59', '计算机与通信工程学院', '8', '计算机与通信工程学院事务通知');
INSERT INTO `tab` VALUES ('60', '文学', '1', '分享你的文学生活');
INSERT INTO `tab` VALUES ('61', '考研', '1', '考研经验分享与收获');
INSERT INTO `tab` VALUES ('62', '四六级', '1', '四六级经验分享与收获');
INSERT INTO `tab` VALUES ('63', '雅思', '1', '雅思经验分享与收获');

-- ----------------------------
-- Table structure for unread
-- ----------------------------
DROP TABLE IF EXISTS `unread`;
CREATE TABLE `unread` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '未读信息索引',
  `user_id` varchar(12) COLLATE utf8_bin NOT NULL COMMENT '用户索引id',
  `info` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '未读信息',
  `infocome_id` varchar(12) COLLATE utf8_bin DEFAULT NULL COMMENT '发送信息者的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of unread
-- ----------------------------
INSERT INTO `unread` VALUES ('1', '3', '是时候测试下未读信息了', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(1) NOT NULL AUTO_INCREMENT COMMENT '索引id',
  `user_role` int(10) NOT NULL COMMENT '用户角色类型',
  `user_id` varchar(12) NOT NULL COMMENT '用户id(学号、工号)',
  `user_name` varchar(10) NOT NULL COMMENT '用户名',
  `user_pwd` varchar(20) NOT NULL COMMENT '用户密码',
  `user_phone` varchar(11) NOT NULL COMMENT '用户手机号',
  `user_college` varchar(10) NOT NULL COMMENT '用户所处院系',
  `problem_id` int(5) NOT NULL COMMENT '找回功能问题的问题id',
  `problem_answer` varchar(20) NOT NULL COMMENT '找回功能问题答案',
  `user_sex` varchar(2) NOT NULL COMMENT '用户性别',
  `user_img` varchar(30) DEFAULT NULL COMMENT '用户头像',
  `unread_message` int(255) unsigned DEFAULT '0' COMMENT '未读消息数',
  `post_collection_num` int(255) unsigned DEFAULT '0' COMMENT '收藏帖子数',
  `focus_number` int(255) unsigned DEFAULT '0' COMMENT '关注的人数',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2', '541513250153', 'root', 'admin', '13222222222', '软件学院', '1', '息县三中', '男', null, '0', '0', '0');
INSERT INTO `user` VALUES ('2', '1', '541513250132', '吹不散眉弯', '111', '15222222222', '软件学院', '1', '息县一中', '女', null, '0', '0', '1');
INSERT INTO `user` VALUES ('3', '1', '541513250222', '一首歌从深情唱', '111', '15299999999', '计算机与通信工程学院', '1', '息县三中', '男', null, '1', '0', '2');
INSERT INTO `user` VALUES ('4', '1', '544513250136', '朝气蓬勃', '111', '15638053724', '软件学院', '1', '息县三中', '男', null, '0', '0', '0');
