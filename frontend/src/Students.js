import React, { } from 'react';
import { Pagination, List, Datagrid, Edit, Create, SimpleForm, DateField, TextField, EditButton, DisabledInput, TextInput, LongTextInput, DateInput, SelectInput, ReferenceInput } from 'react-admin';

const PostPagination = props => <Pagination rowsPerPageOptions={[]} {...props} />;

export const StudentList = (props) => (
    <List {...props} bulkActionButtons={false} pagination={<PostPagination />}>
        <Datagrid>
            <TextField source="id" sortable={false} />
            <TextField source="name" sortable={false} />
			<TextField source="course.name" sortable={false} />
            <EditButton />
        </Datagrid>
    </List>
);

const StudentTitle = ({ record }) => {
    return <span>Student id : {record ? `"${record.id}"` : ''}</span>;
};

export const StudentEdit = (props) => (
    <Edit title={<StudentTitle />} {...props}>
        <SimpleForm validate={validateStudentForm}>
            <TextInput disabled source="id" />
            <TextInput source="name" />
			<ReferenceInput label="Course" source="courseid" reference="courses" >
              <SelectInput optionText="name" />
            </ReferenceInput>
        </SimpleForm>
    </Edit>
);

const validateStudentForm = (values) => {
    const errors = {};

   
    if (!values.name) {
        errors.name = ['name is required'];
    }

    return errors;
}

export const StudentCreate = (props) => (
    <Create title="Add new Student" {...props}>
        <SimpleForm validate={validateStudentForm}>
            <TextInput source="name" />
			<ReferenceInput label="Course" source="courseid" reference="courses" >
              <SelectInput optionText="name" />
            </ReferenceInput>
        </SimpleForm>
    </Create>
);