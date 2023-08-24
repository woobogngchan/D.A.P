package domain.teacher.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String teacherName;

    @Column(nullable = false)
    private String nickName;

    @Column
    private int age;

    @Column(nullable = false)
    private TeacherJanre janre;

    @Column
    private String originalTeacherImage;

    @Column
    private Long teacherImageSize;

    @Column
    @OneToMany
    private String teacherImage;

    public Teacher(String teacherName, String nickName, int age, TeacherJanre janre, String originalTeacherImage, Long teacherImageSize, String teacherImage) {
        this.teacherName = teacherName;
        this.nickName = nickName;
        this.age = age;
        this.janre = janre;
        this.originalTeacherImage = originalTeacherImage;
        this.teacherImageSize = teacherImageSize;
        this.teacherImage = teacherImage;
    }
}
