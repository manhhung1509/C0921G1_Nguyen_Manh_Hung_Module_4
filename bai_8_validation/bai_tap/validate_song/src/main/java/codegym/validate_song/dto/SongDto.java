package codegym.validate_song.dto;

import javax.validation.constraints.*;

public class SongDto {
    private Long id;
    @NotBlank(message = "no blanks or spaces")
    @Size(max = 800, message = "Number of characters must be less than 800 letters")
    @Pattern(regexp = "^([\\p{Lu}\\p{Ll}\\s0-9](,)?)*$", message = "must not contain special characters")
    private String name;

    @NotBlank(message = "no blanks or spaces")
    @Size(max = 300, message = "Number of characters must be less than 300 letters")
    @Pattern(regexp = "^^([\\p{Lu}\\p{Ll}\\s0-9](,)?)*$", message = "must not contain special characters")
    private String singer;

    @NotBlank(message = "no blanks or spaces")
    @Size(max = 1000, message = "Number of characters must be less than 1000 letters")
    @Pattern(regexp = "^([\\p{Lu}\\p{Ll}\\s0-9](,)?)*$", message = "must not contain special characters except (,)")
    private String typeSong;

    public SongDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }

}
