package com.service;
import com.entity.Group;
import com.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository _groupRepository){
        this.groupRepository = _groupRepository;
    }

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public Group getGroup(String id){
        return groupRepository.findById(id).get();
    }

    public Group addGroup(Group group){
        return groupRepository.save(group);
    }

    public Group updateGroup(String id, Group groupRequest){
        Group group = groupRepository.findById(id).get();
        group.setName(groupRequest.getName());
        return groupRepository.save(group);
    }

    public void deleteGroup(String id){
        Group group = this.getGroup(id);
        groupRepository.delete(group);
    }

}