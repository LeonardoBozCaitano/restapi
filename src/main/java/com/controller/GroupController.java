package com.controller;

import com.entity.Group;
import com.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="API Rest - Groups")
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping("/grupos")
    @ApiOperation(value="Return a group List")
    public List<Group> getAllGroups(){
        return groupService.getAllGroups();
    }

    @RequestMapping("/grupos/{id}")
    @ApiOperation(value="Return a group")
    public Group getGroup(@PathVariable(value="id") String id){
        return groupService.getGroup(id);
    }

    @PostMapping("/grupos")
    @ApiOperation(value="Add a group")
    public Group addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
    }

    @PutMapping("/grupos/{id}")
    @ApiOperation(value="Update a group")
    public Group updateGroup(@PathVariable String id, @RequestBody Group group) {
        return groupService.updateGroup(id, group);
    }

    @DeleteMapping("/grupos/{id}")
    @ApiOperation(value="Delete a group")
    public void deleteGroup(@PathVariable String id) {
        groupService.deleteGroup(id);
    }
}
