package constructor.classes

data class User constructor(
    val phoneNumber: String = "9999999973",
    val smsCode: String = "1111",
    val name: String,
    val surname: String = "",
    val patronymic: String = "",
    val email: String = "",
    val city: String = "",
    val street: String = "",
    val homeNumber: String = ""
)

/*
Тут можно было не указывать номера телефона, так как объявил этот номер по умолчанию
в конструткоре класса User
 */
val user = User(
    phoneNumber = "9999999973",
    name = "SamPoSebe",
    email = "i.kapustin.test1@gmail.com",
    city = "Саранск",
    street = "ул. Ленина",
    homeNumber = "1"
)