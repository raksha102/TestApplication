package com.application.testapplication;

import com.application.testapplication.application.constants.AppConstants;
import com.application.testapplication.data.datasource.DataSource;
import com.application.testapplication.data.model.mapper.Mapper;
import com.application.testapplication.data.model.mapper.UserMapperImpl;
import com.application.testapplication.data.model.response.main.UserAccountResponse;
import com.application.testapplication.data.repository.UserRepository;
import com.application.testapplication.data.repository.UserRepositoryImpl;
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataValidationTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private String jsonResponseString;

    @Mock
    DataSource mDataSource;

    Mapper mMapper;
    private UserRepositoryImpl mUserRepository;
    private UserAccountModel mUserAccountModel;

    @Before
    public void setUp() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("assets/collection.json");
        jsonResponseString = FileUtil.readFromFle(inputStream);

        when(mDataSource.getUserDetail())
                .then((Answer<Flowable<UserAccountResponse>>)
                        invocation -> Flowable.just(new Gson().fromJson(jsonResponseString,
                                UserAccountResponse.class)));

        mMapper = new UserMapperImpl();
        mUserRepository = new UserRepositoryImpl(mDataSource, mMapper);
        mUserAccountModel = mUserRepository.getUserDetail().blockingFirst();
    }

    @Test
    public void testJsonResponseString() {
        assertThat(jsonResponseString, notNullValue());
    }

    @Test
    public void testRepositoryData() {
        mUserRepository.getUserDetail().test().assertSubscribed();
        mUserRepository.getUserDetail().test().assertNoErrors();
    }

    @Test
    public void testNonEmpty(){
        assertNotNull(mUserAccountModel);
    }

    @Test
    public void testDataSize(){
        assertEquals(4,mUserAccountModel.getUserData().size());
    }

    @Test
    public void testLoginId(){
        assertEquals(AppConstants.USER_LOGIN_ID,mUserAccountModel.getUserData()
                .get(AppConstants.TYPE_SERVICES).getMsn());
    }

    @Test
    public void testEmailId(){
        assertEquals("test@mivi.com",mUserAccountModel.getUserData()
                .get(AppConstants.TYPE_ACCOUNT).getEmail());
    }

    @Test
    public void testPaymentType(){
        assertEquals("prepaid",mUserAccountModel.getUserData()
                .get(AppConstants.TYPE_ACCOUNT).getPaymentType());
    }


}