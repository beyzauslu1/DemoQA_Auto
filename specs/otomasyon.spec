# DemoQA Practice Form Tests

## 1-Açılış testi
* Go to google

## 2-Form sayfası başarıyla açılmalı
* Form sayfası açılır
* Form sayfası kontrol edilir

## 3-İsim başarıyla girilmeli
* Form sayfası açılır
* Fill First Name

## 4-Soyisim başarıyla girilmeli
* Form sayfası açılır
* Fill Last Name

## 5-First Name alanına rakam girilmemeli
* Form sayfası açılır
* "firstName" alanına "firstNameInvalidNumber" verisi girilir

## 6-First Name alanına karakter girilmemeli
* Form sayfası açılır
* "firstName" alanına "firstNameInvalidChar" verisi girilir

## 7-Last Name alanına rakam girilmemeli
* Form sayfası açılır
* "lastName" alanına "lastNameInvalidNumber" verisi girilir

## 8-Last Name alanına karakter girilmemeli
* Form sayfası açılır
* "lastName" alanına "lastNameInvalidChar" verisi girilir

## 9-First Name boş bırakıldığında form submit edilememeli
* Form sayfası açılır
* Fill Last Name
* Select Female Gender
* Fill Phone
* Submit Form
* "firstName" alanı hata vermeli
* Form gönderilmemelidir

## 10-Last Name boş bırakıldığında form submit edilememeli
* Form sayfası açılır
* Fill First Name
* Select Male Gender
* Fill Phone
* Submit Form
* "lastName" alanı hata vermeli
* Form gönderilmemelidir

## 11-Email başarıyla girilmeli
* Form sayfası açılır
* Fill Email

## 12-Geçersiz email girildiğinde hata vermeli
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* Fill Phone
* "userEmail" alanına "userEmailInvalid" verisi girilir
* Submit Form
* "userEmail" alanı hata vermeli
* Form gönderilmemelidir

## 13-.com olmadan girilen email hata vermeli
* Form sayfası açılır
* "userEmail" alanına "userEmailMissingDotCom" verisi girilir
* Submit Form
* "userEmail" alanı hata vermeli

## 14-Mobile number alanına harf veya karakter girildiğinde kabul edilmemeli
* Form sayfası açılır
* "userNumber" alanına "userNumberInvalid" verisi girilir
* "userNumber" alanında sadece rakam kalmalı

## 15-Geçersiz numara girildiğinde hata vermeli
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* "userNumber" alanına "userNumberInvalid" verisi girilir
* Submit Form
* "userNumber" alanı hata vermeli

## 16-Subjects alanına geçersiz değer girildiğinde kaydedilmemeli
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* Select Female Gender
* Fill Phone
* "subjectsInput" alanına "subjectInvalid" verisi girilir
* Submit Form

## 17-Birden fazla ders seçilebilmeli
* Form sayfası açılır
* "subjectsInput" alanına "subjectArts" verisi girilir
* "subjectsInput" alanına "subjectMaths" verisi girilir

## 18-Gender seçilmediğinde form submit edilememeli
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* Fill Phone
* Submit Form
* Form gönderilmemelidir

## 19-Sport hobisi seçildiğinde form kaydedilebilmeli
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* Select Male Gender
* Fill Phone
* hobbies alanına "hobbySports" verisi girilir
* Submit Form
* Form başarıyla kaydedilmeli

## 20-Reading hobisi seçildiğinde form kaydedilebilmeli
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* Select Female Gender
* Fill Phone
* hobbies alanına "hobbyReading" verisi girilir
* Submit Form
* Form başarıyla kaydedilmeli

## 21-Music hobisi seçildiğinde form kaydedilebilmeli
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* Select Male Gender
* Fill Phone
* hobbies alanına "hobbyMusic" verisi girilir
* Submit Form
* Form başarıyla kaydedilmeli

## 22- Doğum tarihi bugünden sonraki bir tarih olmamalı
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* Select Female Gender
* Fill Phone
* date alanına "birthDateFuture" verisi girilir
* "dateOfBirth" alanı hata vermeli
* Submit Form
* Form gönderilmemelidir

## 23-Current Address alanı doldurulmalı
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* Select Female Gender
* Fill Phone
* Fill Address
* Submit Form
* Form başarıyla kaydedilmeli

## 24-Resim alanına dosya yüklenmesi
* Form sayfası açılır
* Fill First Name
* Fill Last Name
* Select Female Gender
* Fill Phone
* Upload File

## 25-State olarak NCR seçilir
* Form sayfası açılır
* Select State NCR

## 26-State olarak Uttar Pradesh seçilir
* Form sayfası açılır
* Select State Uttar Pradesh

## 27-State olarak Haryana seçilir
* Form sayfası açılır
* Select State Haryana

## 28-State olarak Rajastan seçilir
* Form sayfası açılır
* Select State Rajastan

## 29-State seçildiğinde City seçilmeden form kaydedilmemeli
* Form sayfası açılır
* Select State NCR
* Fill First Name
* Fill Last Name
* Select Male Gender
* Fill Phone
* Submit Form
* Formda state bilgisi görünmemelidir

## 30-NCR seçildiğinde City olarak Gurgaon seçilebilmeli
* Form sayfası açılır
* Select State NCR
* Select City Gurgaon
* Fill First Name
* Fill Last Name
* Select Male Gender
* Fill Phone
* Submit Form
* Form başarıyla kaydedilmeli

## 31-Uttar Pradesh seçildiğinde City olarak Agra seçilebilmeli
* Form sayfası açılır
* Select State Uttar Pradesh
* Select City Agra
* Fill First Name
* Fill Last Name
* Select Female Gender
* Fill Phone
* Submit Form
* Form başarıyla kaydedilmeli

## 32-Uttar Pradesh seçildiğinde City olarak Lucknow seçilebilmeli
* Form sayfası açılır
* Select State Uttar Pradesh
* Select City Lucknow
* Fill First Name
* Fill Last Name
* Select Female Gender
* Fill Phone
* Submit Form
* Form başarıyla kaydedilmeli

## 33-Haryana seçildiğinde City olarak Karnal seçilebilmeli
* Form sayfası açılır
* Select State Haryana
* Select City Karnal
* Fill First Name
* Fill Last Name
* Select Female Gender
* Fill Phone
* Submit Form
* Form başarıyla kaydedilmeli

## 34-Kullanıcı formu başarılı şekilde doldurur / e2e
* Form sayfası açılır
* Select State NCR
* Select City Delhi
* Upload File
* "subjectsInput" alanına "subjectMaths" verisi girilir
* Fill First Name
* Fill Last Name
* Select Male Gender
* Fill Phone
* hobbies alanına "hobbyReading" verisi girilir
* Fill Address
* date alanına "birthDate" verisi girilir
* Fill Email
* Submit Form
* Form başarıyla kaydedilmeli
