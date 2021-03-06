package com.service_exchange.api_services.restcontrollers

import com.service_exchange.api_services.bussinesslayer.SkillBussness
import com.service_exchange.api_services.dao.dto.ServiceDTO
import com.service_exchange.api_services.dao.dto.SkillDTO
import com.service_exchange.api_services.dao.dto.UserDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = arrayOf("*"))
@RequestMapping("/skill")
class SkillRestfull {
    @Autowired
    lateinit var skillussnes: SkillBussness

    @RequestMapping(value = ["/getAll"], method = arrayOf(RequestMethod.GET))
    fun getAllSkill(): List<SkillDTO> =
            skillussnes.getAllSkills()

    @RequestMapping(value = ["/getMain"], method = arrayOf(RequestMethod.GET))
    fun getMainSkill(): List<SkillDTO> =
            skillussnes.getMainSkill()

    @RequestMapping(value = ["/getChild"], method = arrayOf(RequestMethod.GET))
    fun getMainSkill(skillId: Int): List<SkillDTO> =
            skillussnes.getSkillChildern(skillId)

    @RequestMapping(value = ["/getServices"], method = arrayOf(RequestMethod.GET))
    fun getSkillServices(skillId: Int, type: String, page: Int): List<ServiceDTO> =
            skillussnes.getServiceUsedBySkill(skillId, type, page)

    @RequestMapping(value = ["/getUsers"], method = arrayOf(RequestMethod.GET))
    fun getSkillUser(skillId: Int, page: Int): List<UserDTO> =
            skillussnes.getUsersWithSkill(skillId, page)

    @RequestMapping(value = ["/getTop"], method = arrayOf(RequestMethod.GET))
    fun getSkillsMostImplemented(size: Int): List<SkillDTO> =
            skillussnes.getTopSkills(size)


}