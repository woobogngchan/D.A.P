package domain.academy.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String academyId;

    @Column(nullable = false)
    private String academyPw;

    @Column(nullable = false)
    private String academyName;

    @Column
    private String academyInfo;

    @Column(nullable = false)
    private AcademyCiyEnum city;

    @Column(nullable = false)
    private AcademyDistrictEnum district;

    @Column(nullable = false)
    private String academyPhoneNum;

    @Builder
    public Academy(String academyId, String academyPw, String academyInfo, String academyName, String academyPhoneNum, AcademyCiyEnum city, AcademyDistrictEnum district){
        this.academyId = academyId;
        this.academyInfo = academyInfo;
        this.academyName = academyName;
        this.academyPw = academyPw;
        this.academyPhoneNum = academyPhoneNum;
        this.city = city;
        this.district = district;
    }
}
