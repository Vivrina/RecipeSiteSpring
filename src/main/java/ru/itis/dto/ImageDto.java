package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Image;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDto {
    private Long id;

    private Long size;

    private String type;

    private String uuidName;

    public static ImageDto from(Image image){
        return ImageDto.builder()
                .id(image.getId())
                .size(image.getSize())
                .uuidName(image.getUuidName())
                .build();
    }

    public static List<ImageDto> from(List<Image> images){
        return images.stream().map(ImageDto::from).collect(Collectors.toList());
    }
}
