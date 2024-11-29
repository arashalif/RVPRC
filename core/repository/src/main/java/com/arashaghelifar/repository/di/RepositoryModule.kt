package com.arashaghelifar.repository.di

import com.arashaghelifar.repository.DefaultRepository
import com.arashaghelifar.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(defaultApiSource: DefaultRepository): Repository
}