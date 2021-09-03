package com.hospital_management.hospital.Service;

import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.*;
import com.hospital_management.hospital.Entity.*;
import com.hospital_management.hospital.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(user);
        return baseResponse;
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public BaseResponse deleteById(Integer id) {
        BaseResponse baseResponse = new BaseResponse();

        userRepository.deleteById(id);

        baseResponse.setData(id);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public BaseResponse updateById(UserDTO userDTO) {
        BaseResponse baseResponse = new BaseResponse();

        Optional<User> existUser = userRepository.findById(userDTO.getUserId());
        existUser.get().setUserId(userDTO.getUserId());
        existUser.get().setUserName(userDTO.getUserName());
        existUser.get().setPassword(userDTO.getPassword());
        existUser.get().setIsActive(userDTO.getIsActive());
        existUser.get().setIsDelete(userDTO.getIsDelete());

        userRepository.save(existUser.get());

        baseResponse.setData(existUser);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public Page<User> findUserWithPagination(int offset, int pageSize) {
        Page<User> user = userRepository.findAll(PageRequest.of(offset, pageSize));
        return user;
    }

//patientService

    public BaseResponse addPatientInfo(PatientDTO patientDTO) {
        Patient patient = new Patient();
        BaseResponse baseResponse = new BaseResponse();
        patient.setPatientId(patientDTO.getPatientId());
        patient.setPatientName(patientDTO.getPatientName());
        patient.setIsActive(patientDTO.getIsActive());
        patient.setIsDelete(patientDTO.getIsDelete());

        patientRepositroy.save(patient);

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(patient);
        return baseResponse;
    }

    public Patient getPatientById(Integer id) {
        return patientRepositroy.findById(id).orElse(null);
    }

    public BaseResponse deletePatientById(Integer id) {
        BaseResponse baseResponse = new BaseResponse();

        patientRepositroy.deleteById(id);

        baseResponse.setData(id);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public BaseResponse updatePatientById(PatientDTO patientDTO) {
        BaseResponse baseResponse = new BaseResponse();

        Optional<Patient> existPatient = patientRepositroy.findById(patientDTO.getPatientId());
        existPatient.get().setPatientId(patientDTO.getPatientId());
        existPatient.get().setPatientName(patientDTO.getPatientName());
        existPatient.get().setIsActive(patientDTO.getIsActive());
        existPatient.get().setIsDelete(patientDTO.getIsDelete());

        patientRepositroy.save(existPatient.get());

        baseResponse.setData(existPatient);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public Page<Patient> findPatientWithPagination(int offset, int pageSize) {
        Page<Patient> patient = patientRepositroy.findAll(PageRequest.of(offset, pageSize));
        return patient;
    }

    //doctorService

    public BaseResponse addDoctorInfo(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        BaseResponse baseResponse = new BaseResponse();
        doctor.setDoctorId(doctorDTO.getDoctorId());
        doctor.setDoctorName(doctorDTO.getDoctorName());
        doctor.setIsActive(doctorDTO.getIsActive());
        doctor.setIsDelete(doctorDTO.getIsDelete());

        doctorRepository.save(doctor);

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(doctor);
        return baseResponse;
    }

    public Doctor getDoctorById(Integer id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public BaseResponse deleteDoctorById(Integer id) {
        BaseResponse baseResponse = new BaseResponse();

        doctorRepository.deleteById(id);

        baseResponse.setData(id);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }
    public BaseResponse updateDoctorById(DoctorDTO doctorDTO) {
        BaseResponse baseResponse = new BaseResponse();

        Optional<Doctor> existDoctor = doctorRepository.findById(doctorDTO.getDoctorId());
        existDoctor.get().setDoctorName(doctorDTO.getDoctorName());
        existDoctor.get().setIsActive(doctorDTO.getIsActive());
        existDoctor.get().setIsDelete(doctorDTO.getIsDelete());

        doctorRepository.save(existDoctor.get());

        baseResponse.setData(existDoctor);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public Page<Doctor> findDoctorWithPagination(int offset, int pageSize) {
        Page<Doctor> doctor = doctorRepository.findAll(PageRequest.of(offset, pageSize));
        return doctor;
    }

    //diseaseService

    public BaseResponse addDiseaseInfo(DiseaseDTO diseaseDTO) {
        Disease disease = new Disease();
        BaseResponse baseResponse = new BaseResponse();
        disease.setDiseaseId(diseaseDTO.getDiseaseId());
        disease.setDiseaseName(diseaseDTO.getDiseaseName());
        disease.setIsActive(diseaseDTO.getIsActive());
        disease.setIsDelete(diseaseDTO.getIsDelete());

        diseaseRepositroy.save(disease);

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(disease);
        return baseResponse;
    }
    public List<Disease> listAllDisease() {
        return diseaseRepositroy.findAll();
    }
    public BaseResponse deleteDiseaseById(Integer id) {
        BaseResponse baseResponse = new BaseResponse();

        diseaseRepositroy.deleteById(id);

        baseResponse.setData(id);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public BaseResponse updateDiseaseById(DiseaseDTO diseaseDTO) {
        BaseResponse baseResponse = new BaseResponse();

        Optional<Disease> existDisease = diseaseRepositroy.findById(diseaseDTO.getDiseaseId());
        existDisease.get().setDiseaseName(diseaseDTO.getDiseaseName());
        existDisease.get().setIsActive(diseaseDTO.getIsActive());
        existDisease.get().setIsDelete(diseaseDTO.getIsDelete());

        diseaseRepositroy.save(existDisease.get());

        baseResponse.setData(existDisease);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    //AppointmentService

    public BaseResponse addAppointmentInfo(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        BaseResponse baseResponse = new BaseResponse();
        appointment.setAppointmentId(appointmentDTO.getAppointmentId());
        appointment.setAppointmentName(appointmentDTO.getAppointmentName());
        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
        appointment.setIsActive(appointmentDTO.getIsActive());
        appointment.setIsDelete(appointmentDTO.getIsDelete());

        appointmentRepository.save(appointment);

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(appointment);
        return baseResponse;
    }
    public List<Appointment> listAllAppointment() {
        return appointmentRepository.findAll();
    }
    public BaseResponse deleteAppointmentById(Integer id) {
        BaseResponse baseResponse = new BaseResponse();

        appointmentRepository.deleteById(id);

        baseResponse.setData(id);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public BaseResponse updateAppointmentById(AppointmentDTO appointmentDTO) {
        BaseResponse baseResponse = new BaseResponse();

        Optional<Appointment> existAppointment = appointmentRepository.findById(appointmentDTO.getAppointmentId());
        existAppointment.get().setAppointmentName(appointmentDTO.getAppointmentName());
        existAppointment.get().setAppointmentTime(appointmentDTO.getAppointmentTime());
        existAppointment.get().setIsActive(appointmentDTO.getIsActive());
        existAppointment.get().setIsDelete(appointmentDTO.getIsDelete());

        appointmentRepository.save(existAppointment.get());

        baseResponse.setData(existAppointment);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }
}