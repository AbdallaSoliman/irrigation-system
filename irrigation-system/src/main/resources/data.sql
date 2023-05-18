INSERT INTO CROP(ID,CREATE_DATE_TIME,UPDATE_DATE_TIME ,NAME,CROP_WATER_NEED ,TOTAL_GROWING_PERIOD_PER_DAY ) values ( '7d00bb7c-ce60-472f-81dd-5d1ff3c0dc4f',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),'Alfalfa',1200,233);

INSERT INTO "PUBLIC"."LAND" VALUES

                                (UUID 'bf2fa421-939c-4bcd-a845-8a20720f550f', TIMESTAMP '2023-05-18 23:39:40.505457', TIMESTAMP '2023-05-18 23:39:40.506432', 100.0, TIMESTAMP '2023-05-18 23:41:11.575049', 'abdalla soliman'),

                                (UUID '3d939194-c296-425d-bf3d-ca2dc104098f', TIMESTAMP '2023-05-18 23:40:02.992812', TIMESTAMP '2023-05-18 23:40:02.993777', 120.0, NULL, 'ali mahmoud'),

                                (UUID '6b22bec8-1375-44c4-91bd-b782503c06df', TIMESTAMP '2023-05-18 23:40:24.940982', TIMESTAMP '2023-05-18 23:40:24.940982', 125.0, NULL, 'ali ahmed');

INSERT INTO "PUBLIC"."LAND_CONFIGURATION" VALUES

    (UUID '8cbd99b2-146e-4def-8f00-844c7a95b8c5', TIMESTAMP '2023-05-18 23:41:00.052291', TIMESTAMP '2023-05-18 23:41:00.052291', 1000, TIMESTAMP '2023-09-30 20:30:03.958', 10000, TIMESTAMP '2023-05-17 11:30:03.958', 12, UUID '7d00bb7c-ce60-472f-81dd-5d1ff3c0dc4f', UUID 'bf2fa421-939c-4bcd-a845-8a20720f550f');
INSERT INTO "PUBLIC"."SLOT" VALUES

                                (UUID '8adbe1cb-1654-4488-9285-3ce24c4eec6d', TIMESTAMP '2023-05-18 23:39:40.519665', TIMESTAMP '2023-05-18 23:39:40.519665', 3, NULL, TIMESTAMP '2023-05-18 23:42:21.534398', 0, NULL, 'OPEN', UUID 'bf2fa421-939c-4bcd-a845-8a20720f550f'),

                                (UUID '3a2931b0-4135-4faa-bfbb-98ff4eee5cd5', TIMESTAMP '2023-05-18 23:39:40.521348', TIMESTAMP '2023-05-18 23:39:40.521348', 1, NULL, TIMESTAMP '2023-05-18 23:42:21.525883', 0, NULL, 'OPEN', UUID 'bf2fa421-939c-4bcd-a845-8a20720f550f'),

                                (UUID 'e85b76a3-9e91-47de-b333-8c45ffec42be', TIMESTAMP '2023-05-18 23:39:40.521852', TIMESTAMP '2023-05-18 23:39:40.521852', 2, NULL, TIMESTAMP '2023-05-18 23:42:21.520527', 0, 'ERROR', 'OPEN', UUID 'bf2fa421-939c-4bcd-a845-8a20720f550f'),

                                (UUID '25c4a507-495a-4e6c-ad8a-1b39ba02819d', TIMESTAMP '2023-05-18 23:39:40.522852', TIMESTAMP '2023-05-18 23:39:40.522852', 4, NULL, TIMESTAMP '2023-05-18 23:42:21.530811', 0, NULL, 'OPEN', UUID 'bf2fa421-939c-4bcd-a845-8a20720f550f'),

                                (UUID '858be3e0-d8d0-4961-8753-97b8a5030bd5', TIMESTAMP '2023-05-18 23:40:02.994771', TIMESTAMP '2023-05-18 23:40:02.994771', 4, NULL, NULL, 0, NULL, 'CLOSE', UUID '3d939194-c296-425d-bf3d-ca2dc104098f'),

                                (UUID '96c11f8b-784a-4a9b-8cf2-2ab46a4f8563', TIMESTAMP '2023-05-18 23:40:02.995852', TIMESTAMP '2023-05-18 23:40:02.995852', 5, NULL, NULL, 0, NULL, 'CLOSE', UUID '3d939194-c296-425d-bf3d-ca2dc104098f'),

                                (UUID '71d695ff-dcd1-4210-928b-f4bcb25ec22c', TIMESTAMP '2023-05-18 23:40:02.996766', TIMESTAMP '2023-05-18 23:40:02.996766', 2, NULL, NULL, 0, NULL, 'CLOSE', UUID '3d939194-c296-425d-bf3d-ca2dc104098f'),

                                (UUID '95ab42bc-5e62-44a9-bebf-744fc2a09ccc', TIMESTAMP '2023-05-18 23:40:02.997777', TIMESTAMP '2023-05-18 23:40:02.998761', 1, NULL, NULL, 0, NULL, 'CLOSE', UUID '3d939194-c296-425d-bf3d-ca2dc104098f'),

                                (UUID 'b943ddaf-6029-4543-ade6-1428e8b64ddb', TIMESTAMP '2023-05-18 23:40:02.999758', TIMESTAMP '2023-05-18 23:40:02.999758', 3, NULL, NULL, 0, NULL, 'CLOSE', UUID '3d939194-c296-425d-bf3d-ca2dc104098f'),

                                (UUID '0fa7f01d-3176-40ef-bb27-953d2b6bb0d1', TIMESTAMP '2023-05-18 23:40:24.941982', TIMESTAMP '2023-05-18 23:40:24.942978', 3, NULL, NULL, 0, NULL, 'CLOSE', UUID '6b22bec8-1375-44c4-91bd-b782503c06df'),

                                (UUID '0a3b666e-f1ab-4e28-974e-fc0f832c3bf1', TIMESTAMP '2023-05-18 23:40:24.943975', TIMESTAMP '2023-05-18 23:40:24.943975', 5, NULL, NULL, 0, NULL, 'CLOSE', UUID '6b22bec8-1375-44c4-91bd-b782503c06df'),

                                (UUID 'a47d3d23-b0df-4d00-8823-6da72684f90d', TIMESTAMP '2023-05-18 23:40:24.944971', TIMESTAMP '2023-05-18 23:40:24.944971', 1, NULL, NULL, 0, NULL, 'CLOSE', UUID '6b22bec8-1375-44c4-91bd-b782503c06df'),

                                (UUID '0b02b233-5b10-4c09-b659-d290158f5d86', TIMESTAMP '2023-05-18 23:40:24.946043', TIMESTAMP '2023-05-18 23:40:24.946043', 2, NULL, NULL, 0, NULL, 'CLOSE', UUID '6b22bec8-1375-44c4-91bd-b782503c06df'),

                                (UUID 'a2013803-b35a-4286-8e32-68c740c3241f', TIMESTAMP '2023-05-18 23:40:24.94697', TIMESTAMP '2023-05-18 23:40:24.94697', 4, NULL, NULL, 0, NULL, 'CLOSE', UUID '6b22bec8-1375-44c4-91bd-b782503c06df');