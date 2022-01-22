// in src/App.js
import * as React from "react";
import { Admin, Resource, ListGuesser } from 'react-admin';
import dataProvider from './studentAppDataProvider';
import { CourseList, CourseEdit, CourseCreate } from './Courses'
import { StudentList, StudentEdit, StudentCreate } from './Students'

//const dataProvider = simpleRestProvider('https://localhost:8080/api');
const App = () => (
    <Admin dataProvider={dataProvider}>
        <Resource name="courses" list={CourseList} edit={CourseEdit} create={CourseCreate}  />
		<Resource name="students" list={StudentList} edit={StudentEdit} create={StudentCreate}/>
    </Admin>
);

export default App;