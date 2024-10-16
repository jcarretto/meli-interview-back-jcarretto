package com.meli.interview.back.subscription_api.unit;

import com.meli.interview.back.subscription_api.domain.models.Subscription;
import com.meli.interview.back.subscription_api.domain.models.User;
import com.meli.interview.back.subscription_api.infrastructure.daos.subscriptionDAO.SubscriptionDAO;
import com.meli.interview.back.subscription_api.infrastructure.session.UserSession;
import com.meli.interview.back.subscription_api.services.SubscriptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {

    @Mock
    private SubscriptionDAO subscriptionDAO;
    @Mock
    private UserSession userSession;

    @InjectMocks
    private SubscriptionService subscriptionService;

    private User user;
    private List<User> friends;
    private User firstFriend;
    private User secondFriend;

    private Subscription meliMas;
    private Subscription spotify;
    private Subscription disney;

    private ArrayList<Subscription> firstFriendSubscriptions;
    private ArrayList<Subscription> secondFriendSubscriptions;

    @BeforeEach
    public void setUp(){
        user = new User("Pepe");
        user.setId("1");

        firstFriend = new User("First");
        firstFriend.setId("2");
        secondFriend = new User("Second");
        secondFriend.setId("3");

        friends = new ArrayList<>(List.of(firstFriend,secondFriend));

        user.addFriends(friends);
    }

    private void createSubscriptions(){
        meliMas = new Subscription("MeliMas",100);
        spotify = new Subscription("Spotify",50);
        disney = new Subscription("Disney",200);

        firstFriendSubscriptions = new ArrayList<>(List.of(meliMas));
        secondFriendSubscriptions = new ArrayList<>(List.of(spotify,disney));
    }

    private void setupTestMocks() throws Exception {
        when(subscriptionDAO.findSubscriptionByUser(firstFriend)).thenReturn(firstFriendSubscriptions);
        when(subscriptionDAO.findSubscriptionByUser(secondFriend)).thenReturn(secondFriendSubscriptions);

        Field instanceField = UserSession.class.getDeclaredField("userSession");
        instanceField.setAccessible(true);
        instanceField.set(null, userSession);

        when(userSession.getLoggedUser()).thenReturn(user);
    }

    @Test
    @DisplayName("CALCULATE TOTAL SUBSCRIPTIONS COST")
    public void calculateTotalSubscriptionCost() throws Exception {
        //Arrange
        createSubscriptions();

        firstFriend.addSubscriptions(firstFriendSubscriptions);
        secondFriend.addSubscriptions(secondFriendSubscriptions);

        setupTestMocks();

        //Act
        float firstFriendTotalCost = subscriptionService.getUserSubscriptionsCost(firstFriend);
        float secondFriendTotalCost = subscriptionService.getUserSubscriptionsCost(secondFriend);

        //Assert
        assertEquals(100,firstFriendTotalCost);
        assertEquals(250,secondFriendTotalCost);
    }
}
