DROP TABLE IF EXISTS step;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS project_category;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS project;


CREATE TABLE project(
	project_id INTEGER AUTO_INCREMENT NOT NULL,
	project_name VARCHAR(128) NOT NULL,
	estimated_hours DECIMAL(7,2),
	actual_hours DECIMAL(7,2),
	difficulty INTEGER,
	notes TEXT,
	PRIMARY KEY (project_id)
);

CREATE TABLE category(
	category_id INTEGER AUTO_INCREMENT NOT NULL,
	category_name VARCHAR(128) NOT NULL,
	PRIMARY KEY (category_id)
);

CREATE TABLE project_category(
	project_id INTEGER NOT NULL,
	category_id INTEGER NOT NULL,
	FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE,
	FOREIGN KEY (category_id) REFERENCES category(category_id) ON DELETE CASCADE,
	UNIQUE KEY (project_id,category_id)
);

CREATE TABLE material(
	material_id INTEGER AUTO_INCREMENT NOT NULL,
	project_id INTEGER NOT NULL,
	material_name VARCHAR(128) NOT NULL,
	num_required INTEGER,
	cost DECIMAL(7,2),
	PRIMARY KEY (material_id),
	FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE
);

CREATE TABLE step(
	step_id INTEGER AUTO_INCREMENT NOT NULL,
	project_id INTEGER NOT NULL,
	step_text TEXT NOT NULL,
	step_order INTEGER NOT NULL,
	PRIMARY KEY (step_id),
	FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
);