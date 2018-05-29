/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_exchange.api_services.dao.user;

import com.service_exchange.api_services.dao.challanges.ChallangeDao;
import com.service_exchange.entities.Complaint;
import com.service_exchange.entities.Education;
import com.service_exchange.entities.UserTable;
import com.service_exchange.utal.UnoptimizedDeepCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 *
 * @author Altysh
 */
@Component
public class UserDaoImpl implements UserInterFace {

    @Autowired
    private UserDataInterFace dataInterface;

    @Autowired
    private ChallangeDao challangeDao;

    private int pageSize = 20;

    @Override
    public UserTable getUser(Integer userId) {
        Optional<UserTable> user = dataInterface.findById(userId);
        return user.orElse(null);
    }

    private <T> List convertList(Collection<T> coll) {
        List list;
        if (coll instanceof List) {
            list = (List) coll;
        } else {
            list = new ArrayList(coll);
        }
        return list;
    }

    @Override
    public UserTable createUser(UserTable user) {

        return dataInterface.save(user);
    }

    @Override
    public UserTable updateUser(UserTable user) {
        return (UserTable) UnoptimizedDeepCopy.copy(dataInterface.save(user));
    }

    @Override
    public Boolean checkEmailAvalible(Integer email) {
        return dataInterface.findById(email).isPresent();
    }

    @Override
    @Transactional
    public Page<UserTable> getAllUser(int start) {

        return dataInterface.findAll(PageRequest.of(start, pageSize));
    }

    public List<UserTable> getAllUser() {
        List<UserTable> list = new LinkedList<>();
        // System.out.println(t.getComplaintCollection());
        dataInterface.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Page<UserTable> scerchUserByName(String name, int start) {
        return dataInterface.findByNameContains(name, PageRequest.of(start, start + 20));

    }



    @Override
    public Boolean changePic(String url, Integer userId) {
        UserTable user = getUser(userId);
        if (user != null) {
            user.setImage(url);
            return true;
        }
        return false;
    }

    @Override
    public Boolean addEductaion(Education education, Integer userId) {
        UserTable user = getUser(userId);
        if (user != null) {
            user.addEducation(education);
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeEductaion(Education education, Integer userId) {
        UserTable user = getUser(userId);
        if (user != null) {
            user.removeEducation(education);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Education> getEducation(Integer userId) {
        UserTable user = getUser(userId);
        if (user != null) {
            return user.getEducationCollection();
        }
        return null;
    }


    @Override
    public List<Complaint> getUserComplaints(Integer userId) {
        UserTable user = getUser(userId);
        if (user != null) {
            return convertList(user.getComplaintCollection());
        }
        return null;
    }


}
