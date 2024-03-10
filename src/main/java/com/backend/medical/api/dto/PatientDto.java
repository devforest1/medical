package com.backend.medical.api.dto;

import com.backend.medical.entity.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private long patientId; // 환자 ID
    private long hospitalId; // 병원 ID
    @NotNull
    private String name; // 환자명
    @NotNull
    private String gender; // 성별
    private String uuid; // 환자등록코드
    private String birthday; // 생년월일
    private String phoneNumber; // 휴대폰 전화번호

    public PatientDto (Patient patient) {
        this.name = patient.getName();
        this.patientId = patient.getId();
        this.hospitalId = patient.getHospital().getId();
        this.birthday = patient.getBirthday();
        this.gender = patient.getGenderCode().equals("M") ? "남성" : "여성";
        this.uuid = patient.getPatientUuid();
        this.phoneNumber = patient.getPhoneNumber();
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "patientId=" + patientId +
                ", hospitalId=" + hospitalId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", uuid='" + uuid + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
