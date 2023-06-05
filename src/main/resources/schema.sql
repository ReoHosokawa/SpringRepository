-- 商品テーブル
CREATE TABLE IF NOT EXISTS item (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nameId bigint(20) NOT NULL,
  price int NOT NULL,
  taxRate int NOT NULL DEFAULT 0,
  priceWithTax int NOT NULL DEFAULT 0,
  vendorId bigint(20) NOT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 商品名マスタ
CREATE TABLE IF NOT EXISTS masterItemName (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ベンダーマスタ
CREATE TABLE IF NOT EXISTS masterVendor (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ユーザマスタ
CREATE TABLE IF NOT EXISTS masterUser (
  id varchar(50) NOT NULL UNIQUE,
  name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
