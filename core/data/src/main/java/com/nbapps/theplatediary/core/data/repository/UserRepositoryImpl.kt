package com.nbapps.theplatediary.core.data.repository

import com.nbapps.theplatediary.core.data.local.dao.UserDao
import com.nbapps.theplatediary.core.data.repository.mapper.toDomain
import com.nbapps.theplatediary.core.data.repository.mapper.toEntity
import com.nbapps.theplatediary.core.domain.model.User
import com.nbapps.theplatediary.core.domain.model.UserProfile
import com.nbapps.theplatediary.core.domain.repository.UserRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
) : UserRepository {
    override suspend fun upsertUser(user: User) = userDao.upsertUser(user.toEntity())

    override suspend fun upsertProfile(profile: UserProfile) = userDao.upsertProfile(profile.toEntity())

    override fun observeUser(userId: String): Flow<User?> = userDao.observeUser(userId).map { it?.toDomain() }

    override fun observeProfile(userId: String): Flow<UserProfile?> =
        userDao.observeProfile(userId).map { it?.toDomain() }
}
