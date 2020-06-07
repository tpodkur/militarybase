create sequence hibernate_sequence start 1 increment 1;

create table armia
(
    id         int4 not null,
    kapitan_id int4,
    primary key (id)
);

create table artilleria
(
    id              int4    not null,
    characteristic1 boolean not null,
    characteristic2 varchar(255),
    characteristic3 int4,
    vid             varchar(255),
    vooruzhenie_id  int4,
    primary key (id)
);

create table automat_oruzhie
(
    id              int4    not null,
    characteristic1 boolean not null,
    characteristic2 varchar(255),
    characteristic3 int4,
    vid             varchar(255),
    vooruzhenie_id  int4,
    primary key (id)
);

create table autotransport
(
    id              int4    not null,
    characteristic1 boolean not null,
    characteristic2 varchar(255),
    characteristic3 int4,
    transport_id    int4,
    vid             varchar(255),
    primary key (id)
);

create table bmp
(
    id              int4    not null,
    characteristic1 boolean not null,
    characteristic2 varchar(255),
    characteristic3 int4,
    transport_id    int4,
    vid             varchar(255),
    primary key (id)
);

create table brigada
(
    id         int4 not null,
    armia_id   int4,
    kapitan_id int4,
    primary key (id)
);

create table divizia
(
    id         int4 not null,
    kapitan_id int4,
    korpus_id  int4,
    primary key (id)
);

create table efreytor
(
    id                 int4    not null,
    characteristic1    boolean not null,
    characteristic2    varchar(255),
    characteristic3    int4,
    ryadovoy_sostav_id int4,
    primary key (id)
);

create table general
(
    id               int4    not null,
    characteristic1  boolean not null,
    characteristic2  varchar(255),
    characteristic3  int4,
    oficer_sostav_id int4,
    primary key (id)
);

create table kapitan
(
    id               int4    not null,
    characteristic1  boolean not null,
    characteristic2  varchar(255),
    characteristic3  int4,
    oficer_sostav_id int4,
    primary key (id)
);

create table karabin
(
    id              int4    not null,
    characteristic1 boolean not null,
    characteristic2 varchar(255),
    characteristic3 int4,
    vid             varchar(255),
    vooruzhenie_id  int4,
    primary key (id)
);

create table korpus
(
    id         int4 not null,
    brigada_id int4,
    kapitan_id int4,
    primary key (id)
);

create table leytenant
(
    id               int4    not null,
    characteristic1  boolean not null,
    characteristic2  varchar(255),
    characteristic3  int4,
    oficer_sostav_id int4,
    primary key (id)
);

create table maior
(
    id               int4    not null,
    characteristic1  boolean not null,
    characteristic2  varchar(255),
    characteristic3  int4,
    oficer_sostav_id int4,
    primary key (id)
);

create table oficer_sostav
(
    id        int4 not null,
    person_id int4,
    primary key (id)
);

create table otdelenie
(
    id         int4 not null,
    kapitan_id int4,
    vzvod_id   int4,
    primary key (id)
);

create table person
(
    dtype      varchar(31) not null,
    id         int4        not null,
    active     boolean     not null,
    first_name varchar(255),
    last_name  varchar(255),
    oficer_id  int4,
    third_name varchar(255),
    user_id    int4,
    primary key (id)
);

create table podpolkovnik
(
    id               int4    not null,
    characteristic1  boolean not null,
    characteristic2  varchar(255),
    characteristic3  int4,
    oficer_sostav_id int4,
    primary key (id)
);

create table polkovnik
(
    id               int4    not null,
    characteristic1  boolean not null,
    characteristic2  varchar(255),
    characteristic3  int4,
    oficer_sostav_id int4,
    primary key (id)
);

create table praporshik
(
    id                 int4    not null,
    characteristic1    boolean not null,
    characteristic2    varchar(255),
    characteristic3    int4,
    ryadovoy_sostav_id int4,
    primary key (id)
);

create table raketnoe_oruzhie
(
    id              int4    not null,
    characteristic1 boolean not null,
    characteristic2 varchar(255),
    characteristic3 int4,
    vid             varchar(255),
    vooruzhenie_id  int4,
    primary key (id)
);

create table rota
(
    id                 int4 not null,
    kapitan_id         int4,
    voinskaya_chast_id int4,
    primary key (id)
);

create table ryadovoy_model
(
    id                 int4    not null,
    characteristic1    boolean not null,
    characteristic2    varchar(255),
    characteristic3    int4,
    ryadovoy_sostav_id int4,
    primary key (id)
);

create table ryadovoy_sostav
(
    id           int4 not null,
    otdelenie_id int4,
    person_id    int4,
    primary key (id)
);

create table serzhant
(
    id                 int4    not null,
    characteristic1    boolean not null,
    characteristic2    varchar(255),
    characteristic3    int4,
    ryadovoy_sostav_id int4,
    primary key (id)
);

create table sooruzhenie
(
    id   int4 not null,
    name varchar(255),
    primary key (id)
);

create table starshina
(
    id                 int4    not null,
    characteristic1    boolean not null,
    characteristic2    varchar(255),
    characteristic3    int4,
    ryadovoy_sostav_id int4,
    primary key (id)
);

create table transport
(
    id                 int4 not null,
    voinskaya_chast_id int4,
    primary key (id)
);

create table tyagach
(
    id              int4    not null,
    characteristic1 boolean not null,
    characteristic2 varchar(255),
    characteristic3 int4,
    transport_id    int4,
    vid             varchar(255),
    primary key (id)
);

create table usr
(
    id       int4 not null,
    password varchar(255),
    role     varchar(255),
    username varchar(255),
    primary key (id)
);

create table voinskaya_chast
(
    id         int4 not null,
    divizia_id int4,
    kapitan_id int4,
    primary key (id)
);

create table vooruzhenie
(
    id                 int4 not null,
    voinskaya_chast_id int4,
    primary key (id)
);

create table vzvod
(
    id         int4 not null,
    kapitan_id int4,
    rota_id    int4,
    primary key (id)
);

alter table if exists armia
    add constraint FK3ju7l4qs4lvgw0u5u1iql14au foreign key (kapitan_id) references oficer_sostav;

alter table if exists brigada
    add constraint FKaa39uqs31iimkemb3bkdmh2pp foreign key (armia_id) references armia;

alter table if exists brigada
    add constraint FK2rtunq2xlu39dq0bkeclmd4r8 foreign key (kapitan_id) references oficer_sostav;

alter table if exists divizia
    add constraint FK8dg8tnaokkwhfjhncf0nfyouc foreign key (kapitan_id) references oficer_sostav;

alter table if exists divizia
    add constraint FKe2p3u2wonpoucat1m1aignxvm foreign key (korpus_id) references korpus;

alter table if exists efreytor
    add constraint FKoghai9hbhmflmxy1pwxfvow94 foreign key (ryadovoy_sostav_id) references ryadovoy_sostav;

alter table if exists general
    add constraint FKd9dqu48ba5ks1ga19pdvx429d foreign key (oficer_sostav_id) references oficer_sostav;

alter table if exists kapitan
    add constraint FK63eaw2dwemrfn4poa395nd5dj foreign key (oficer_sostav_id) references oficer_sostav;

alter table if exists korpus
    add constraint FKntxmp8m35n8rp7ks37vhqv9tw foreign key (brigada_id) references brigada;

alter table if exists korpus
    add constraint FKhoaj8hsoy0vnr2anfw8ceerdb foreign key (kapitan_id) references oficer_sostav;

alter table if exists leytenant
    add constraint FKad48igpoprw6vu1jj8gsyvr8h foreign key (oficer_sostav_id) references oficer_sostav;

alter table if exists maior
    add constraint FK487jnw3re14kq7yfglxrc5i94 foreign key (oficer_sostav_id) references oficer_sostav;

alter table if exists oficer_sostav
    add constraint FKhdehax7qoq7fgkwrf5umscmli foreign key (person_id) references person;

alter table if exists otdelenie
    add constraint FKmro7w4kr1wfjidk1sf5fvx8r6 foreign key (kapitan_id) references person;

alter table if exists otdelenie
    add constraint FKri6mn49v1b2a1bgxmdtgee2u3 foreign key (vzvod_id) references vzvod;

alter table if exists person
    add constraint FK3p75h7c73rfdvc8c02rg3kqlr foreign key (user_id) references usr;

alter table if exists podpolkovnik
    add constraint FK3pfhbnhfjx7vajib28jr5qe3g foreign key (oficer_sostav_id) references oficer_sostav;

alter table if exists polkovnik
    add constraint FK8o65t3glkvvsqda6rejsjj786 foreign key (oficer_sostav_id) references oficer_sostav;

alter table if exists praporshik
    add constraint FKjcxye2a3bdygshxmtv3jsspby foreign key (ryadovoy_sostav_id) references ryadovoy_sostav;

alter table if exists rota
    add constraint FKnhntrxko0dsk79vrmlt68ve49 foreign key (kapitan_id) references oficer_sostav;

alter table if exists rota
    add constraint FKgtngc8cpivpb98srianf8mtqe foreign key (voinskaya_chast_id) references voinskaya_chast;

alter table if exists ryadovoy_model
    add constraint FKipk8eydkcgl1jbp2hfv5thgeq foreign key (ryadovoy_sostav_id) references ryadovoy_sostav;

alter table if exists ryadovoy_sostav
    add constraint FKft5o2amjxj3ys0ntus6bf06x4 foreign key (otdelenie_id) references otdelenie;

alter table if exists ryadovoy_sostav
    add constraint FKmerru5wbcpbv95jrqnfxthr14 foreign key (person_id) references person;

alter table if exists serzhant
    add constraint FKmw3gn6b6deisijhvyk5ys2br8 foreign key (ryadovoy_sostav_id) references ryadovoy_sostav;

alter table if exists starshina
    add constraint FK47f8nf6vp4yop1bbs3pteslrn foreign key (ryadovoy_sostav_id) references ryadovoy_sostav;

alter table if exists voinskaya_chast
    add constraint FKh0wg2fldyohe95eyd1qgfoeos foreign key (divizia_id) references divizia;

alter table if exists voinskaya_chast
    add constraint FKkpy0fxeekv4o0ay1i5uc60rsk foreign key (kapitan_id) references oficer_sostav;

alter table if exists vzvod
    add constraint FKbahnov3t0i3xeji32juok1rei foreign key (kapitan_id) references person;

alter table if exists vzvod
    add constraint FKcnvf6tfktl0fd98elclhjdll7 foreign key (rota_id) references rota;