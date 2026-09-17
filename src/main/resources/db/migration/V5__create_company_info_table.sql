CREATE TABLE company_info (
    id BIGSERIAL PRIMARY KEY,
    mission TEXT NOT NULL,
    vision TEXT NOT NULL,
    history TEXT NOT NULL,
    founded_year INTEGER,
    updated_at TIMESTAMP NOT NULL DEFAULT now()
);

INSERT INTO company_info (mission, vision, history, founded_year)
VALUES (
    'Brindar soluciones de software innovadoras que impulsen el crecimiento de nuestros clientes.',
    'Ser la empresa de software líder en la región, reconocida por la calidad y confiabilidad de nuestras soluciones.',
    'Fundada por un equipo apasionado por la tecnología, comenzamos desarrollando soluciones a medida para pequeñas empresas.',
    2020
);