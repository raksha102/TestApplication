package com.application.testapplication.injection.module;

import com.application.testapplication.data.datasource.DataSource;
import com.application.testapplication.data.datasource.DataSourceImpl;
import com.application.testapplication.data.model.mapper.Mapper;
import com.application.testapplication.data.model.mapper.UserMapperImpl;
import com.application.testapplication.data.repository.UserRepository;
import com.application.testapplication.data.repository.UserRepositoryImpl;
import com.application.testapplication.injection.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {

    @ApplicationScope
    @Binds
    abstract DataSource bindDataSource(DataSourceImpl dataSource);

    @ApplicationScope
    @Binds
    abstract Mapper bindMapper(UserMapperImpl userMapper);

    @ApplicationScope
    @Binds
    abstract UserRepository bindUserRepository(UserRepositoryImpl userRepository);
}
