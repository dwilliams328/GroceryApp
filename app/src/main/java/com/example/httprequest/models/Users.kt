import java.io.Serializable

data class Users(
    val token: String,
    val user: User
)

data class User(
    val __v: Int?,
    val _id: String?,
    val createdAt: String?,
    val email: String?,
    val firstName: String?,
    val mobile: String?,
    val password: String?
): Serializable{
        companion object{
            var KEY_USER = "key_user"
        }
}