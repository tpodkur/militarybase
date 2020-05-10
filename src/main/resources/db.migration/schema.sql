create table people (
    id_man      NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    first_name  varchar(255),
    last_name   varchar(255),
    third_name  varchar(255)
);

create table oficersky_sostav (
    id_oficer   NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_man      integer unique,
    foreign key (id_man) references people(id_man)
);

create table generali (
    id_general  NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_oficer   integer,
    char_1      varchar(255),
    char_2      integer,
    char_3      date,
    foreign key (id_oficer) references oficersky_sostav(id_oficer)
);

create table polkovniki (
    id_polkovnik    NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_oficer       integer,
    char_1          varchar(255),
    char_2          integer,
    char_3          date,
    foreign key (id_oficer) references oficersky_sostav(id_oficer)
);

create table podpolkovniki (
    id_podpolkovnik NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_oficer       integer,
    char_1          varchar(255),
    char_2          integer,
    char_3          date,
    foreign key (id_oficer) references oficersky_sostav(id_oficer)
);

create table mayori (
    id_mayor        NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_oficer       integer,
    char_1          varchar(255),
    char_2          integer,
    char_3          date,
    foreign key (id_oficer) references oficersky_sostav(id_oficer)
);

create table kapitani (
    id_kapitan      NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_oficer       integer,
    char_1          varchar(255),
    char_2          integer,
    char_3          date,
    foreign key (id_oficer) references oficersky_sostav(id_oficer)
);

create table leytenanti (
    id_leytenant    NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_oficer       integer,
    char_1          varchar(255),
    char_2          integer,
    char_3          date,
    foreign key (id_oficer) references oficersky_sostav(id_oficer)
);

-----------------------------------------------------------------------

create table sooruzhenia (
    id_sooruzhenie  NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    name            varchar(255)
);

-----------------------------------------------------------------------

create table armii (
    id_armia        NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_komandir     integer,
    foreign key (id_komandir) references oficersky_sostav(id_man)
);

create table brigadi (
    id_brigada      NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_komandir     integer,
    id_armia        integer,
    foreign key (id_komandir) references oficersky_sostav(id_man),
    foreign key (id_armia) references armii(id_armia)
);

create table korpusa (
    id_korpus      NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_komandir    integer,
    id_brigada     integer,
    foreign key (id_komandir) references oficersky_sostav(id_man),
    foreign key (id_brigada) references brigadi(id_brigada)
);

create table divizii (
    id_divizia    NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_komandir   integer,
    id_korpus     integer,
    foreign key (id_komandir) references oficersky_sostav(id_man),
    foreign key (id_korpus) references korpusa(id_korpus)
);

create table voinskie_chasti (
    id_chast       NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_komandir    integer,
    id_divizia     integer,
    foreign key (id_komandir) references oficersky_sostav(id_man),
    foreign key (id_divizia) references divizii(id_divizia)
);

create table roti (
    id_rota       NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_komandir   integer,
    id_chast      integer,
    foreign key (id_komandir) references oficersky_sostav(id_man),
    foreign key (id_chast) references voinskie_chasti(id_chast)
);

create table vzvodi (
    id_vzvod      NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_komandir   integer,
    id_rota       integer,
    foreign key (id_komandir) references oficersky_sostav(id_man),
    foreign key (id_rota) references roti(id_rota)
);

create table otdelenia (
    id_otdelenie   NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_komandir    integer,
    id_vzvod       integer,
    foreign key (id_komandir) references oficersky_sostav(id_man),
    foreign key (id_vzvod) references vzvodi(id_vzvod)
);

-----------------------------------------------------------------------

create table ryadovoy_sostav (
    id_ryadovoy  NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_man       integer,
    id_otdelenie integer,
    foreign key (id_man) references people(id_man),
    foreign key (id_otdelenie) references otdelenia(id_otdelenie)
);

create table starshini (
    id_starshina    NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_ryadovoy     integer,
    char_1          varchar(255),
    char_2          integer,
    char_3          date,
    foreign key (id_ryadovoy) references ryadovoy_sostav(id_ryadovoy)
);

create table serzhanti (
    id_serzhant     NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_ryadovoy     integer,
    char_1          varchar(255),
    char_2          integer,
    char_3          date,
    foreign key (id_ryadovoy) references ryadovoy_sostav(id_ryadovoy)
);

create table praporshiki (
    id_praporshik   NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_ryadovoy     integer,
    char_1          varchar(255),
    char_2          integer,
    char_3          date,
    foreign key (id_ryadovoy) references ryadovoy_sostav(id_ryadovoy)
);

create table efreitori (
    id_efreitor     NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_ryadovoy     integer,
    char_1          varchar(255),
    char_2          integer,
    char_3          date,
    foreign key (id_ryadovoy) references ryadovoy_sostav(id_ryadovoy)
);

create table ryadovie (
    id_ryadovoy             NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_ryadovoy_foreign                  integer,
    char_1                  varchar(255),
    char_2                  integer,
    char_3                  date,
    foreign key (id_ryadovoy_foreign) references ryadovoy_sostav(id_ryadovoy)
);

-----------------------------------------------------------------------

create table transportnaya_tehnika (
    id_tehnika   NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_chast     integer,
    foreign key (id_chast) references voinskie_chasti(id_chast)
);

create table avtotransport (
    id_avtotransport        NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_tehnika              integer,
    vid                     varchar(255),
    char_1                  varchar(255),
    char_2                  integer,
    char_3                  date,
    foreign key (id_tehnika) references transportnaya_tehnika(id_tehnika)
);

create table tyagachi (
    id_tyagach        NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_tehnika        integer,
    vid               varchar(255),
    char_1            varchar(255),
    char_2            integer,
    char_3            date,
    foreign key (id_tehnika) references transportnaya_tehnika(id_tehnika)
);

create table bmp (
    id_bmp            NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_tehnika        integer,
    vid               varchar(255),
    char_1            varchar(255),
    char_2            integer,
    char_3            date,
    foreign key (id_tehnika) references transportnaya_tehnika(id_tehnika)
);

-----------------------------------------------------------------------

create table vooruzhenie (
    id_vooruzhenie   NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_chast         integer,
    foreign key (id_chast) references voinskie_chasti(id_chast)
);

create table artileria (
    id_artileria      NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_vooruzhenie    integer,
    vid               varchar(255),
    char_1            varchar(255),
    char_2            integer,
    char_3            date,
    foreign key (id_vooruzhenie) references vooruzhenie(id_vooruzhenie)
);

create table karabini (
    id_karabin        NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_vooruzhenie    integer,
    vid               varchar(255),
    char_1            varchar(255),
    char_2            integer,
    char_3            date,
    foreign key (id_vooruzhenie) references vooruzhenie(id_vooruzhenie)
);

create table avtom_oruzhie (
    id_avtom_oruzhie  NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_vooruzhenie    integer,
    vid               varchar(255),
    char_1            varchar(255),
    char_2            integer,
    char_3            date,
    foreign key (id_vooruzhenie) references vooruzhenie(id_vooruzhenie)
);

create table raket_oruzhie (
    id_raket_oruzhie  NUMBER GENERATED ALWAYS as IDENTITY(START WITH 1 INCREMENT by 1) primary key not null,
    id_vooruzhenie    integer,
    vid               varchar(255),
    char_1            varchar(255),
    char_2            integer,
    char_3            date,
    foreign key (id_vooruzhenie) references vooruzhenie(id_vooruzhenie)
);