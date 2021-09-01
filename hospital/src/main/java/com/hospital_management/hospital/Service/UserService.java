package com.hospital_management.hospital.Service;

import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.*;
import com.hospital_management.hospital.Entity.*;
import com.hospital_management.hospital.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional

public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DiseaseRepositroy diseaseRepositroy;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepositroy patientRepositroy;

    public BaseResponse addinfo(UserDTO userDTO) {
        User user = new User();
        BaseResponse baseResponse = new BaseResponse();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setIsActive(userDTO.getIsActive());
        user.setIsDelete(userDTO.getIsDelete());
        userRepository.save(user);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(user);
        return baseResponse;
    }

    public BaseResponse addinfo(PatientDTO patientDTO) {
        Patient patient = new Patient();
        BaseResponse baseResponse = new BaseResponse();
        patient.setPatientName(patientDTO.getPatientName());
        patient.setIsActive(patientDTO.getIsActive());
        patient.setIsDelete(patientDTO.getIsDelete());
        patientRepositroy.save(patient);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(patient);
        return baseResponse;
    }

    public BaseResponse addinfo(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        BaseResponse baseResponse = new BaseResponse();
        doctor.setDoctorName(doctorDTO.getDoctorName());
        doctor.setIsActive(doctorDTO.getIsActive());
        doctor.setIsDelete(doctorDTO.getIsDelete());
        doctorRepository.save(doctor);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(doctor);
        return baseResponse;
    }

    public BaseResponse addinfo(DiseaseDTO diseaseDTO) {
        Disease disease = new Disease();
        BaseResponse baseResponse = new BaseResponse();
        disease.setDiseaseName(diseaseDTO.getDiseaseName());
        disease.setIsActive(diseaseDTO.getIsActive());
        disease.setIsDelete(diseaseDTO.getIsDelete());
        diseaseRepositroy.save(disease);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(disease);
        return baseResponse;
    }

    public BaseResponse addinfo(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        BaseResponse baseResponse = new BaseResponse();
        appointment.setAppointmentName(appointmentDTO.getAppointmentName());
        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
        appointment.setIsActive(appointmentDTO.getIsActive());
        appointment.setIsDelete(appointmentDTO.getIsDelete());
        appointmentRepository.save(appointment);
        baseResponse.setStatusCode("OK");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(appointment);
        return baseResponse;

    }

}