package com.example.pobreflix.data

class UserRepository(private val userDao: UserDao) {
    suspend fun getUser(username: String): UserEntity? {
        return userDao.getUser(username)
    }

    suspend fun register(user: UserEntity): Boolean {
        return if (userDao.getUser(user.username) == null) {
            userDao.register(user)
            true
        } else {
            false // Usuário já existe
        }
    }
}
