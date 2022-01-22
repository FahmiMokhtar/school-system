import React, { } from 'react';
import { Pagination, List, Datagrid, Edit, Create, SimpleForm, DateField, TextField, EditButton, TextInput, LongTextInput, DateInput } from 'react-admin';

const PostPagination = props => <Pagination rowsPerPageOptions={[]} {...props} />;

export const CourseList = (props) => (
    <List {...props} bulkActionButtons={false} pagination={<PostPagination />}>
        <Datagrid>
            <TextField source="id" sortable={false} />
            <TextField source="name" sortable={false} />
            <EditButton />
        </Datagrid>
    </List>
);

const CourseTitle = ({ record }) => {
    return <span>Course id : {record ? `"${record.id}"` : ''}</span>;
};

export const CourseEdit = (props) => (
    <Edit title={<CourseTitle />} {...props}>
        <SimpleForm validate={validateCourseForm}>
            <TextInput disabled source="id" />
            <TextInput source="name" />
        </SimpleForm>
    </Edit>
);

const validateCourseForm = (values) => {
    const errors = {};

   
    if (!values.name) {
        errors.name = ['name is required'];
    }

    return errors;
}

export const CourseCreate = (props) => (
    <Create title="Create a Course" {...props}>
        <SimpleForm validate={validateCourseForm}>
            <TextInput source="name" />
        </SimpleForm>
    </Create>
);