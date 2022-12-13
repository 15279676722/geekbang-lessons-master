package org.geekbang.thinking.in.spring.aop.features.transactional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportSourceBean {
    private Long id;
    private String name;
}
