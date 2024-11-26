package com.ynov.ai.dto;

import lombok.Builder;

@Builder
public record ReponseAIDTO2(int code, String reponse, String nomModel) {
}
