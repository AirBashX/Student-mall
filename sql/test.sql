CREATE TABLE t_user (
	uid INT AUTO_INCREMENT COMMENT '用户的id',
	username VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
	password CHAR(32) NOT NULL COMMENT '密码',
	salt CHAR(36) COMMENT '盐值',
	avatar VARCHAR(50) COMMENT '头像',
	phone VARCHAR(20)  COMMENT '电话',
	email VARCHAR(50)  COMMENT '邮箱',
	gender INT COMMENT '性别，0-女，1-男',
	is_delete INT COMMENT '是否删除，0-未删除，1-已删除',
	created_user VARCHAR(20) COMMENT '创建者',
	created_time DATETIME COMMENT '创建时间',
	modified_user VARCHAR(20) COMMENT '最后修改者',
	modified_time DATETIME COMMENT '最后修改时间',
	PRIMARY KEY(uid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_address (
	aid INT AUTO_INCREMENT COMMENT '收货地址id',
	uid INT COMMENT '归属用户的id',
	name VARCHAR(20) COMMENT '收货人',
	province CHAR(6) COMMENT '省',
	city CHAR(6) COMMENT '市',
	area CHAR(6) COMMENT '区',
	district VARCHAR(50) COMMENT '省市区的汉字名称',
	zip CHAR(6) COMMENT '邮编',
	address VARCHAR(50) COMMENT '详细地址',
	tel VARCHAR(20) COMMENT '固话',
	phone VARCHAR(20) COMMENT '手机',
	tag VARCHAR(20) COMMENT '地址类型',
	is_default INT COMMENT '是否默认：0-非默认，1-默认',
	created_user VARCHAR(20) COMMENT '创建者',
	created_time DATETIME COMMENT '创建时间',
	modified_user VARCHAR(20) COMMENT '最后修改者',
	modified_time DATETIME COMMENT '最后修改时间',
	PRIMARY KEY (aid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_cart(
	cid INT AUTO_INCREMENT COMMENT '购物车数据的id',
	uid INT COMMENT '用户的id',	
	gid BIGINT COMMENT '商品id',
	num INT COMMENT '商品数量',
	created_user VARCHAR(20) COMMENT '创建者',
	created_time DATETIME COMMENT '创建时间',
	modified_user VARCHAR(20) COMMENT '最后修改者',
	modified_time DATETIME COMMENT '最后修改时间',
	PRIMARY KEY(cid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_order (
	oid INT AUTO_INCREMENT COMMENT '订单id',
	uid INT NOT NULL COMMENT '归属用户',
	recv_name VARCHAR(20) COMMENT '收货人姓名',
	recv_phone VARCHAR(20) COMMENT '收货人电话',
	recv_address VARCHAR(100) COMMENT '收货人详细地址',
	total_price BIGINT COMMENT '总价',
	status INT COMMENT '状态：0-未支付，1-已支付，2-已取消',
	order_time DATETIME COMMENT '下单时间',
	pay_time DATETIME COMMENT '支付时间',
	created_user VARCHAR(20) COMMENT '创建者',
	created_time DATETIME COMMENT '创建时间',
	modified_user VARCHAR(20) COMMENT '最后修改者',
	modified_time DATETIME COMMENT '最后修改时间',
	PRIMARY KEY(oid)
) DEFAULT CHARSET=UTF8;

CREATE TABLE t_order_item (
	id INT AUTO_INCREMENT COMMENT '自动递增的数据id',
	oid INT COMMENT '归属的订单的id',
	gid BIGINT COMMENT '商品id',
	goods_title VARCHAR(100) COMMENT '商品标题',
	goods_image VARCHAR(500) COMMENT '商品图片',
	goods_price BIGINT COMMENT '商品价格',
	goods_num INT COMMENT '商品数量',
	created_user VARCHAR(20) COMMENT '创建者',
	created_time DATETIME COMMENT '创建时间',
	modified_user VARCHAR(20) COMMENT '最后修改者',
	modified_time DATETIME COMMENT '最后修改时间',
	PRIMARY KEY(id)
) DEFAULT CHARSET=UTF8;