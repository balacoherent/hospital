package com.hospital_management.hospital.Service;

import com.hospital_management.hospital.BaseResponse.ApiResponse;
import com.hospital_management.hospital.BaseResponse.BaseResponse;
import com.hospital_management.hospital.DTO.*;
import com.hospital_management.hospital.Entity.*;
import com.hospital_management.hospital.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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

        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(user);
        return baseResponse;
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public BaseResponse<User> getUserById(Integer id){
        Optional<User> user=userRepository.findById(id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(user);
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public BaseResponse deleteSoft(UserDTO userDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<User> existUser = userRepository.findByUserId(userDTO.getUserId());
        existUser.get().setIsDelete(1);
        userRepository.save(existUser.get());

        baseResponse.setData(existUser);
        baseResponse.setStatusCode("Ok");
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
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");

        return baseResponse;
    }

    public ApiResponse<User> getUserWithPagination(int offset,int pageSize, String userName) {
        Pageable paging=PageRequest.of(offset,pageSize);
        Page<User> Users = userRepository.searchAllByUserNameLike("%" + userName + "%", paging);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setResponse(Users);
        apiResponse.setRecordCount(Users.getTotalPages());
        return apiResponse;
    }

//patientService

    public BaseResponse addPatientInfo(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setPatientName(patientDTO.getPatientName());
        Patient finalPatient = patient;
        patientDTO.getUserId().stream().forEachOrdered(userDTO -> {
        Optional<User> userId=userRepository.findByUserId(userDTO.getUserId());
        finalPatient.setUserId(userId.get());
    });
        patient.setPatientId(patientDTO.getPatientId());
        patient.setPatientName(patientDTO.getPatientName());
        patient.setIsActive(patientDTO.getIsActive());
        patient.setIsDelete(patientDTO.getIsDelete());
        patientRepositroy.save(patient);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(patient);
        return baseResponse;
    }

    public BaseResponse<Patient> getPatientById(Integer id) {
        Optional<Patient> patient=patientRepositroy.findById(id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(patient);
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }

    public BaseResponse deleteSoftPatient(PatientDTO patientDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Patient> existPatient = patientRepositroy.findByPatientId(patientDTO.getPatientId());
        existPatient.get().setIsDelete(1);
        patientRepositroy.save(existPatient.get());
        baseResponse.setData(existPatient);
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }

    public BaseResponse updatePatientById(PatientDTO patientDTO) {
        Optional<Patient> exitsPatient = patientRepositroy.findById(patientDTO.getPatientId());
        exitsPatient.get().setPatientName(patientDTO.getPatientName());
        patientDTO.getUserId().stream().forEachOrdered(userDTO -> {
            Optional<User> userId=userRepository.findByUserId(userDTO.getUserId());
            exitsPatient.get().setUserId(userId.get());
        });
        Optional<Patient> existPatient = patientRepositroy.findById(patientDTO.getPatientId());
        existPatient.get().setPatientId(patientDTO.getPatientId());
        existPatient.get().setPatientName(patientDTO.getPatientName());
        existPatient.get().setIsActive(patientDTO.getIsActive());
        existPatient.get().setIsDelete(patientDTO.getIsDelete());
        patientRepositroy.save(existPatient.get());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(existPatient);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }

    public ApiResponse<Patient> getPatientWithPagination(int offset,int pageSize, String patientName) {
        Pageable paging=PageRequest.of(offset,pageSize);
        Page<Patient> patients = patientRepositroy.searchAllByPatientNameLike("%" + patientName + "%", paging);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setResponse(patients);
        apiResponse.setRecordCount(patients.getTotalPages());
        return apiResponse;
    }

    //doctorService

    public BaseResponse addDoctorInfo(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setDoctorName(doctorDTO.getDoctorName());
        Doctor finalDoctor = doctor;
        doctorDTO.getUserId().stream().forEachOrdered(userDTO -> {
            Optional<User> userId=userRepository.findByUserId(userDTO.getUserId());
            finalDoctor.setUserId(userId.get());
        });
        doctor.setDoctorId(doctorDTO.getDoctorId());
        doctor.setDoctorName(doctorDTO.getDoctorName());
        doctor.setIsActive(doctorDTO.getIsActive());
        doctor.setIsDelete(doctorDTO.getIsDelete());
        doctorRepository.save(doctor);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(doctor);
        return baseResponse;
    }

    public BaseResponse<Doctor> getDoctorById(Integer id) {
        Optional<Doctor> doctor=doctorRepository.findById(id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(doctor);
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }

    public BaseResponse deleteSoftDoctor(DoctorDTO doctorDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Doctor> existDoctor = doctorRepository.findByDoctorId(doctorDTO.getDoctorId());
        existDoctor.get().setIsDelete(1);
        doctorRepository.save(existDoctor.get());
        baseResponse.setData(existDoctor);
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }
    public BaseResponse updateDoctorById(DoctorDTO doctorDTO) {
        Optional<Doctor> exitsDoctor = doctorRepository.findById(doctorDTO.getDoctorId());
        exitsDoctor.get().setDoctorName(doctorDTO.getDoctorName());
        doctorDTO.getUserId().stream().forEachOrdered(userDTO -> {
            Optional<User> userId=userRepository.findByUserId(userDTO.getUserId());
            exitsDoctor.get().setUserId(userId.get());
        });
        exitsDoctor.get().setIsActive(doctorDTO.getIsActive());
        exitsDoctor.get().setIsDelete(doctorDTO.getIsDelete());
        doctorRepository.save(exitsDoctor.get());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(exitsDoctor);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }

    public ApiResponse<Doctor> getDoctorWithPagination(int offset,int pageSize, String doctorName) {
        Pageable paging=PageRequest.of(offset,pageSize);
        Page<Doctor> doctors = doctorRepository.searchAllByDoctorNameLike("%" + doctorName + "%", paging);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setResponse(doctors);
        apiResponse.setRecordCount(doctors.getTotalPages());
        return apiResponse;
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
    public BaseResponse deleteSoftDisease(DiseaseDTO diseaseDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Disease> existDisease = diseaseRepositroy.findByDiseaseId(diseaseDTO.getDiseaseId());
        existDisease.get().setIsDelete(1);
        diseaseRepositroy.save(existDisease.get());
        baseResponse.setData(existDisease);
        baseResponse.setStatusCode("Ok");
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
        appointment.setAppointmentName(appointmentDTO.getAppointmentName());
        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
        Appointment finalAppointment = appointment;
        appointmentDTO.getPatientId().stream().forEachOrdered(patientDTO -> {
            Optional<Patient> patient=patientRepositroy.findByPatientId(patientDTO.getPatientId());
            finalAppointment.setPatientId(patient.get());
        });

        Appointment finalAppointment1 = appointment;
        appointmentDTO.getDoctorId().stream().forEachOrdered(doctorDTO -> {
            Optional<Doctor> doctor=doctorRepository.findByDoctorId(doctorDTO.getDoctorId());
            finalAppointment1.setDoctorId(doctor.get());
        });

        Appointment finalAppointment2 = appointment;
        appointmentDTO.getDiseaseId().stream().forEachOrdered(diseaseDTO -> {
            Optional<Disease> disease=diseaseRepositroy.findByDiseaseId(diseaseDTO.getDiseaseId());
            finalAppointment2.setDiseaseId(disease.get());
        });

        appointment.setIsActive(appointmentDTO.getIsActive());
        appointment.setIsDelete(appointmentDTO.getIsDelete());
        appointment= appointmentRepository.save(appointment);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        baseResponse.setData(appointment);
        return baseResponse;
    }
    public List<Appointment> listAllAppointment() {
        return appointmentRepository.findAll();
    }

    public BaseResponse<Appointment> getAppointmentById(Integer id) {
    Optional<Appointment> appointment=appointmentRepository.findById(id);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(appointment);
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }

    public BaseResponse deleteSoftAppointment(AppointmentDTO appointmentDTO) {
        Optional<Appointment> existAppointment = appointmentRepository.findById(appointmentDTO.getAppointmentId());
        existAppointment.get().setIsDelete(1);
        appointmentRepository.save(existAppointment.get());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(existAppointment);
        baseResponse.setStatusCode("Ok");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }

    public BaseResponse updateAppointmentById(AppointmentDTO appointmentDTO) {
        Optional<Appointment> existAppointment = appointmentRepository.findById(appointmentDTO.getAppointmentId());
        existAppointment.get().setAppointmentName(appointmentDTO.getAppointmentName());
        existAppointment.get().setAppointmentTime(appointmentDTO.getAppointmentTime());

        appointmentDTO.getPatientId().stream().forEachOrdered(patientDTO -> {
            Optional<Patient> patientId=patientRepositroy.findByPatientId(patientDTO.getPatientId());
            existAppointment.get().setPatientId(patientId.get());
        });

        appointmentDTO.getDoctorId().stream().forEachOrdered(doctorDTO -> {
            Optional<Doctor> doctorId=doctorRepository.findByDoctorId(doctorDTO.getDoctorId());
            existAppointment.get().setDoctorId(doctorId.get());
        });

        appointmentDTO.getDiseaseId().stream().forEachOrdered(diseaseDTO -> {
            Optional<Disease> diseaseId=diseaseRepositroy.findByDiseaseId(diseaseDTO.getDiseaseId());
            existAppointment.get().setDiseaseId(diseaseId.get());
        });

        existAppointment.get().setIsActive(appointmentDTO.getIsActive());
        existAppointment.get().setIsDelete(appointmentDTO.getIsDelete());
        appointmentRepository.save(existAppointment.get());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(existAppointment);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }
}