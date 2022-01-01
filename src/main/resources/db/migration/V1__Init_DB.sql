create sequence streamer_sequence start 1 increment 1;
create sequence video_sequence start 1 increment 1;

create table streamer (
    id int8 not null,
    description text,
    firstname varchar(255),
    lastname varchar(255),
    picture_name varchar(255),
    pseudonym varchar(255) not null,
    primary key (id)
);

ALTER TABLE streamer
    ALTER COLUMN id
    SET DEFAULT NEXTVAL('streamer_sequence');

create table streamer_other_pseudonyms (
    streamer_id int8 not null,
    other_pseudonym varchar(255)
);

create table video (
       id int8 not null,
       description varchar(255),
       name varchar(255),
       youtube_id varchar(255),
       primary key (id)
);

ALTER TABLE video
    ALTER COLUMN id
    SET DEFAULT NEXTVAL('video_sequence');

create table streamer_video (
    video_id int8 not null,
    streamer_id int8 not null
);

alter table if exists streamer_other_pseudonyms
    add constraint streamer_other_pseudonym_fk
    foreign key (streamer_id) references streamer;

alter table if exists streamer_video
    add constraint streamer_fk
    foreign key (streamer_id) references streamer;

alter table if exists streamer_video
    add constraint video_fk
    foreign key (video_id) references video;