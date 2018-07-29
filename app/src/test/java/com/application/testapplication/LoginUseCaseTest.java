package com.application.testapplication;

import com.application.testapplication.application.constants.AppConstants;
import com.application.testapplication.data.datasource.DataSource;
import com.application.testapplication.data.model.mapper.Mapper;
import com.application.testapplication.data.model.mapper.UserMapperImpl;
import com.application.testapplication.data.model.response.main.UserAccountResponse;
import com.application.testapplication.data.repository.UserRepositoryImpl;
import com.application.testapplication.domain.executor.PostExecutionThread;
import com.application.testapplication.domain.interactor.LoginUseCase;
import com.application.testapplication.ui.model.data.UserAccountModel;
import com.application.testapplication.utils.FileUtil;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.InputStream;

import io.reactivex.Flowable;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginUseCaseTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private LoginUseCase mUseCase;

    @Before
    public void setUp() {
        mUseCase = new LoginUseCase();
    }

    @Test
    public void testLoginValidLoginId() {
       Boolean isValid =  mUseCase.execute(new LoginUseCase.Params(AppConstants.USER_LOGIN_ID)).blockingGet();
       assertTrue(isValid);
    }

    @Test
    public void testLoginInvalidLoginId() {
        Boolean isValid =  mUseCase.execute(new LoginUseCase.Params("1234")).blockingGet();
        assertFalse(isValid);
    }

    @Test
    public void testLoginOnEmpty() {
        Boolean isValid =  mUseCase.execute(new LoginUseCase.Params("")).blockingGet();
        assertFalse(isValid);
    }

    @Test
    public void testLoginOnNull() {
        Boolean isValid =  mUseCase.execute(new LoginUseCase.Params(null)).blockingGet();
        assertFalse(isValid);
    }

}