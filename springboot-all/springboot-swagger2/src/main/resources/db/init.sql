DROP TABLE IF EXISTS ss_company;
CREATE TABLE ss_company (
  id varchar(40) NOT NULL COMMENT 'ID',
  name varchar(255) DEFAULT NULL COMMENT '公司名称',
  expiration_date datetime DEFAULT NULL COMMENT '到期时间',
  address varchar(255) DEFAULT NULL COMMENT '公司地址',
  license_id varchar(255) DEFAULT NULL COMMENT '营业执照-图片',
  representative varchar(255) DEFAULT NULL COMMENT '法人代表',
  phone varchar(255) DEFAULT NULL COMMENT '公司电话',
  company_size varchar(255) DEFAULT NULL COMMENT '公司规模',
  industry varchar(255) DEFAULT NULL COMMENT '所属行业',
  remarks varchar(255) DEFAULT NULL COMMENT '备注',
  state int(2) DEFAULT '1' COMMENT '状态',
  balance double DEFAULT NULL COMMENT '当前余额',
  city varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO ss_company VALUES ('1', '字节跳动', null, '北京', 'xxx002', '张某', '123', '10000人以上', '互联网', '互联网公司', '1', '100', '北京');
INSERT INTO ss_company VALUES ('2', '百度', null, '北京市海淀区', 'bzd001', '李某', '110', '5000-10000人', '计算机', '', '1', '100', '北京');
INSERT INTO ss_company VALUES ('3', '阿里巴巴', null, '中国杭州市滨江区', 'bzd002', '马某', '110', '5000-10000人', '电子商务', '', '1', '100', '杭州');
INSERT INTO ss_company VALUES ('4', '腾讯', null, '深圳市南山区', 'bzd003', '马某', '110', '5000-10000人', '游戏', '', '1', '100', '深圳');