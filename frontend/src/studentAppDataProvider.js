import { fetchUtils } from 'react-admin';
import { stringify } from 'query-string';

const apiUrl = 'http://127.0.0.1:8080/api';
const httpClient = fetchUtils.fetchJson;

export default {
    getList: (resource, params) => {
        const url = `${apiUrl}/${resource}`;

        return httpClient(url).then(({ headers, json }) => ({
            data: json,
            total: 1,
        }));
    },

    getOne: (resource, params) =>
        httpClient(`${apiUrl}/${resource}/${params.id}`).then(({ json }) => ({
            data: json,
        })),

    getMany: (resource, params) => {

        const url = `${apiUrl}/${resource}`;
        return httpClient(url).then(({ json }) => ({ data: json }));
    },

    getManyReference: (resource, params) => {
       
        const url = `${apiUrl}/${resource}`;

        return httpClient(url).then(({ headers, json }) => ({
            data: json,
            total: 1,
        }));
    },

    update: (resource, params) =>
        httpClient(`${apiUrl}/${resource}/${params.id}`, {
            method: 'PUT',
            body: JSON.stringify(params.data),
        }).then(({ json }) => ({ data: json })),

    updateMany: (resource, params) => {

        return httpClient(`${apiUrl}/${resource}`, {
            method: 'PUT',
            body: JSON.stringify(params.data),
        }).then(({ json }) => ({ data: json }));
    },

    create: (resource, params) =>
        httpClient(`${apiUrl}/${resource}`, {
            method: 'POST',
            body: JSON.stringify(params.data),
        }).then(({ json }) => ({
            data: { ...params.data, id: json.id },
        })),

    delete: (resource, params) =>
        httpClient(`${apiUrl}/${resource}/${params.id}`, {
            method: 'DELETE',
        }).then(({ json }) => ({ data: json })),

    deleteMany: (resource, params) => {
        return httpClient(`${apiUrl}/${resource}`, {
            method: 'DELETE',
        }).then(({ json }) => ({ data: json }));
    }
};