create table user (
  id          integer auto_increment,
  name        varchar(100) not null,
  age         int,
  gender      varchar(10) not null,
  image_url   varchar(255),
  hobby       varchar(255),
  speciality  varchar(255),
  primary key (id)
);

insert into user (name, age, gender, image_url, hobby, speciality)
  values ('伊藤 万理華', 22, 'WOMAN', 'http://livedoor.blogimg.jp/kykzk/imgs/7/4/74edb4a3.jpg', '海苔や鉱石の観察・収集、ダンス、ファッションコーディネート、抹茶スイーツを食べること', '絵を描くこと、クラシックバレエ、変顔');
insert into user (name, age, gender, image_url, hobby, speciality)
  values ('土生 瑞穂', 21, 'WOMAN', 'http://data.jj-jj.net/wp-content/uploads/2018/07/26131746/mizuho.jpg', 'アニメ、ゲーム', 'イメージチェンジ、コスプレ、バレエ');
