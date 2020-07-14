package edu.pitt.medschool.model.dao;


import java.util.List;

import edu.pitt.medschool.framework.util.Util;
import edu.pitt.medschool.model.dto.MedicationExample;
import edu.pitt.medschool.model.mapper.MedicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import edu.pitt.medschool.model.dto.Medication;

@Repository
public class MedicationDao {
    @Autowired
    MedicationMapper medicationMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Transactional(rollbackFor = Exception.class)
    public int insert(Medication medication){
        return medicationMapper.insertSelective(medication);
    }

    public List<Medication> getAllMedInfo(String machine){
        return medicationMapper.getAllMedInfo(machine);
    }

    public List<Medication> getMedInfoById (String machine, String id){
        return medicationMapper.getMedInfoById(machine,id);
    }

    public List<String> selectAllMedication(){
        return medicationMapper.getAllMedicine();
    }

    public List<Medication> selectAllbyMedications(String drugName, List<String> patientIDs,int version){
        String patients = Util.wrapAndConcatStringList("'", ", ", patientIDs);
        logger.info(patients);
        return medicationMapper.selectAllbyMedication(drugName,patients,version);
    }

    public List<String> selectPatientbyMedications(String drugName){
        return medicationMapper.selectPatientsbyMedications(drugName);
    }

    public List<Medication> selectFirstbyMedications(String medicine, List<String> patientIDs,int version) {
        String patients = Util.wrapAndConcatStringList("'", ", ", patientIDs);
        logger.info("first"+patients);
        return medicationMapper.selectFirstMedication(medicine,patients,version);
    }

    public int publishNewData(int currentVersion) {
        MedicationExample medicationExample = new MedicationExample();
        MedicationExample.Criteria criteria = medicationExample.createCriteria();
        criteria.andVersionEqualTo(0);
        Medication medication = new Medication();
        medication.setVersion(currentVersion);
        return medicationMapper.updateByExampleSelective(medication,medicationExample);
    }

    public Long getMedicationIncrease(int currentVersion) {
        MedicationExample medicationExample = new MedicationExample();
        MedicationExample.Criteria criteria = medicationExample.createCriteria();
        criteria.andVersionEqualTo(currentVersion);
        return medicationMapper.countByExample(medicationExample);
    }

    public Long getMedicationNumber(int currentVersion) {
        MedicationExample medicationExample = new MedicationExample();
        MedicationExample.Criteria criteria = medicationExample.createCriteria();
        criteria.andVersionLessThanOrEqualTo(currentVersion);
        return medicationMapper.countByExample(medicationExample);
    }
}
