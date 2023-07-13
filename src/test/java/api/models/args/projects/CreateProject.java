package api.models.args.projects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

public class CreateProject {
        private String name;
        private String description ;
        private String owner_id ;
        private String identifier ;
        private String start_date;
        private String end_date;
    }
