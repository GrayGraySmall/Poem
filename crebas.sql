/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     2016-12-27 17:09:52                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Care') and o.name = 'FK_CARE_INHERITAN_BUSINESS')
alter table Care
   drop constraint FK_CARE_INHERITAN_BUSINESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Foster') and o.name = 'FK_FOSTER_INHERITAN_BUSINESS')
alter table Foster
   drop constraint FK_FOSTER_INHERITAN_BUSINESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"Order"') and o.name = 'FK_ORDER_OB_BUSINESS')
alter table "Order"
   drop constraint FK_ORDER_OB_BUSINESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Pet') and o.name = 'FK_PET_HAVE_USER')
alter table Pet
   drop constraint FK_PET_HAVE_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Treat') and o.name = 'FK_TREAT_INHERITAN_BUSINESS')
alter table Treat
   drop constraint FK_TREAT_INHERITAN_BUSINESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"User"') and o.name = 'FK_USER_INCLUDE_USERKIND')
alter table "User"
   drop constraint FK_USER_INCLUDE_USERKIND
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Worker') and o.name = 'FK_WORKER_SORT_WORKKIND')
alter table Worker
   drop constraint FK_WORKER_SORT_WORKKIND
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('po') and o.name = 'FK_PO_PO_PET')
alter table po
   drop constraint FK_PO_PO_PET
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('po') and o.name = 'FK_PO_PO2_ORDER')
alter table po
   drop constraint FK_PO_PO2_ORDER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('serve') and o.name = 'FK_SERVE_SERVE_WORKER')
alter table serve
   drop constraint FK_SERVE_SERVE_WORKER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('serve') and o.name = 'FK_SERVE_SERVE2_PET')
alter table serve
   drop constraint FK_SERVE_SERVE2_PET
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('uo') and o.name = 'FK_UO_UO_USER')
alter table uo
   drop constraint FK_UO_UO_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('uo') and o.name = 'FK_UO_UO2_ORDER')
alter table uo
   drop constraint FK_UO_UO2_ORDER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Business')
            and   type = 'U')
   drop table Business
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Care')
            and   type = 'U')
   drop table Care
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Foster')
            and   type = 'U')
   drop table Foster
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('"Order"')
            and   name  = 'Order2_FK'
            and   indid > 0
            and   indid < 255)
   drop index "Order".Order2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"Order"')
            and   type = 'U')
   drop table "Order"
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Pet')
            and   name  = 'Have_FK'
            and   indid > 0
            and   indid < 255)
   drop index Pet.Have_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Pet')
            and   type = 'U')
   drop table Pet
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Treat')
            and   type = 'U')
   drop table Treat
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('"User"')
            and   name  = 'include_FK'
            and   indid > 0
            and   indid < 255)
   drop index "User".include_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"User"')
            and   type = 'U')
   drop table "User"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('UserKind')
            and   type = 'U')
   drop table UserKind
go

if exists (select 1
            from  sysobjects
           where  id = object_id('WorkKind')
            and   type = 'U')
   drop table WorkKind
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Worker')
            and   name  = 'sort_FK'
            and   indid > 0
            and   indid < 255)
   drop index Worker.sort_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Worker')
            and   type = 'U')
   drop table Worker
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('po')
            and   name  = 'po2_FK'
            and   indid > 0
            and   indid < 255)
   drop index po.po2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('po')
            and   name  = 'po_FK'
            and   indid > 0
            and   indid < 255)
   drop index po.po_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('po')
            and   type = 'U')
   drop table po
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('serve')
            and   name  = 'serve2_FK'
            and   indid > 0
            and   indid < 255)
   drop index serve.serve2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('serve')
            and   name  = 'serve_FK'
            and   indid > 0
            and   indid < 255)
   drop index serve.serve_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('serve')
            and   type = 'U')
   drop table serve
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('uo')
            and   name  = 'uo2_FK'
            and   indid > 0
            and   indid < 255)
   drop index uo.uo2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('uo')
            and   name  = 'uo_FK'
            and   indid > 0
            and   indid < 255)
   drop index uo.uo_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('uo')
            and   type = 'U')
   drop table uo
go

/*==============================================================*/
/* Table: Business                                              */
/*==============================================================*/
create table Business (
   businessId           int                  identity,
   businessSup          char(100)            null,
   businessPrice        decimal(5,2)         not null,
   constraint PK_BUSINESS primary key (businessId)
)
go

/*==============================================================*/
/* Table: Care                                                  */
/*==============================================================*/
create table Care (
   businessId           int                  not null,
   businessSup          char(100)            null,
   businessPrice        decimal(5,2)         not null,
   careKind             char(20)             not null,
   constraint PK_CARE primary key nonclustered (businessId)
)
go

/*==============================================================*/
/* Table: Foster                                                */
/*==============================================================*/
create table Foster (
   businessId           int                  not null,
   businessSup          char(100)            null,
   businessPrice        decimal(5,2)         not null,
   food                 bit                  not null,
   weight               numeric(3)           not null,
   constraint PK_FOSTER primary key nonclustered (businessId)
)
go

/*==============================================================*/
/* Table: "Order"                                               */
/*==============================================================*/
create table "Order" (
   orderId              int                  not null,
   businessId           int                  null,
   orderTime            datetime             not null,
   cleanTime            datetime             null,
   orderSupp            char(100)            null,
   cost                 decimal(5,3)         null,
   constraint PK_ORDER primary key (orderId)
)
go

/*==============================================================*/
/* Index: Order2_FK                                             */
/*==============================================================*/
create index Order2_FK on "Order" (
businessId ASC
)
go

/*==============================================================*/
/* Table: Pet                                                   */
/*==============================================================*/
create table Pet (
   petId                int                  identity,
   userPhoneNumber      char(12)             null,
   petSex               char(2)              not null,
   petName              char(10)             not null,
   petBirthday          datetime             not null,
   petKind              char(20)             not null,
   petWeight            int                  not null,
   constraint PK_PET primary key (petId)
)
go

/*==============================================================*/
/* Index: Have_FK                                               */
/*==============================================================*/
create index Have_FK on Pet (
userPhoneNumber ASC
)
go

/*==============================================================*/
/* Table: Treat                                                 */
/*==============================================================*/
create table Treat (
   businessId           int                  not null,
   businessSup          char(100)            null,
   businessPrice        decimal(5,2)         not null,
   treatKind            char(20)             not null,
   constraint PK_TREAT primary key nonclustered (businessId)
)
go

/*==============================================================*/
/* Table: "User"                                                */
/*==============================================================*/
create table "User" (
   userPhoneNumber      char(12)             not null,
   kindId               int                  null,
   userName             char(10)             not null,
   userSex              char(2)              not null,
   userIcon             char(30)             not null,
   regerstTime          datetime             not null,
   password             char(20)             not null,
   constraint PK_USER primary key (userPhoneNumber)
)
go

/*==============================================================*/
/* Index: include_FK                                            */
/*==============================================================*/
create index include_FK on "User" (
kindId ASC
)
go

/*==============================================================*/
/* Table: UserKind                                              */
/*==============================================================*/
create table UserKind (
   kindId               int                  identity,
   kindIntro            char(100)            null,
   discount             decimal(5,2)         not null,
   constraint PK_USERKIND primary key (kindId)
)
go

/*==============================================================*/
/* Table: WorkKind                                              */
/*==============================================================*/
create table WorkKind (
   workKindId           int                  identity,
   kindName             char(20)             not null,
   kindIntro            char(100)            null,
   constraint PK_WORKKIND primary key (workKindId)
)
go

/*==============================================================*/
/* Table: Worker                                                */
/*==============================================================*/
create table Worker (
   workerName           char(10)             not null,
   workKindId           int                  null,
   workerBirthday       datetime             null,
   workerTel            char(12)             not null,
   workerIntro          char(100)            not null,
   constraint PK_WORKER primary key (workerName)
)
go

/*==============================================================*/
/* Index: sort_FK                                               */
/*==============================================================*/
create index sort_FK on Worker (
workKindId ASC
)
go

/*==============================================================*/
/* Table: po                                                    */
/*==============================================================*/
create table po (
   petId                int                  not null,
   orderId              int                  not null,
   constraint PK_PO primary key (petId, orderId)
)
go

/*==============================================================*/
/* Index: po_FK                                                 */
/*==============================================================*/
create index po_FK on po (
petId ASC
)
go

/*==============================================================*/
/* Index: po2_FK                                                */
/*==============================================================*/
create index po2_FK on po (
orderId ASC
)
go

/*==============================================================*/
/* Table: serve                                                 */
/*==============================================================*/
create table serve (
   workerName           char(10)             not null,
   petId                int                  not null,
   constraint PK_SERVE primary key (workerName, petId)
)
go

/*==============================================================*/
/* Index: serve_FK                                              */
/*==============================================================*/
create index serve_FK on serve (
workerName ASC
)
go

/*==============================================================*/
/* Index: serve2_FK                                             */
/*==============================================================*/
create index serve2_FK on serve (
petId ASC
)
go

/*==============================================================*/
/* Table: uo                                                    */
/*==============================================================*/
create table uo (
   userPhoneNumber      char(12)             not null,
   orderId              int                  not null,
   constraint PK_UO primary key (userPhoneNumber, orderId)
)
go

/*==============================================================*/
/* Index: uo_FK                                                 */
/*==============================================================*/
create index uo_FK on uo (
userPhoneNumber ASC
)
go

/*==============================================================*/
/* Index: uo2_FK                                                */
/*==============================================================*/
create index uo2_FK on uo (
orderId ASC
)
go

alter table Care
   add constraint FK_CARE_INHERITAN_BUSINESS foreign key (businessId)
      references Business (businessId)
go

alter table Foster
   add constraint FK_FOSTER_INHERITAN_BUSINESS foreign key (businessId)
      references Business (businessId)
go

alter table "Order"
   add constraint FK_ORDER_OB_BUSINESS foreign key (businessId)
      references Business (businessId)
go

alter table Pet
   add constraint FK_PET_HAVE_USER foreign key (userPhoneNumber)
      references "User" (userPhoneNumber)
go

alter table Treat
   add constraint FK_TREAT_INHERITAN_BUSINESS foreign key (businessId)
      references Business (businessId)
go

alter table "User"
   add constraint FK_USER_INCLUDE_USERKIND foreign key (kindId)
      references UserKind (kindId)
go

alter table Worker
   add constraint FK_WORKER_SORT_WORKKIND foreign key (workKindId)
      references WorkKind (workKindId)
go

alter table po
   add constraint FK_PO_PO_PET foreign key (petId)
      references Pet (petId)
go

alter table po
   add constraint FK_PO_PO2_ORDER foreign key (orderId)
      references "Order" (orderId)
go

alter table serve
   add constraint FK_SERVE_SERVE_WORKER foreign key (workerName)
      references Worker (workerName)
go

alter table serve
   add constraint FK_SERVE_SERVE2_PET foreign key (petId)
      references Pet (petId)
go

alter table uo
   add constraint FK_UO_UO_USER foreign key (userPhoneNumber)
      references "User" (userPhoneNumber)
go

alter table uo
   add constraint FK_UO_UO2_ORDER foreign key (orderId)
      references "Order" (orderId)
go

