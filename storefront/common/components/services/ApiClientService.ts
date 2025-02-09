interface RequestOption {
    method: string;
    headers: {
        [key : string] : string;
    }
    body?: string;
}

const sendRequest = async (
    method: string,
    endpoint: string,
    data: any = null,
    contentType: string | null = null

) => {
    const defaultContentType = 'application/json; charset=UTF-8';
    const requestOption : RequestOption = {
        method: method.toUpperCase(),
        headers: {
          'Content-Type': contentType ?? defaultContentType,
        },
    };

    if(data) {
        if(data instanceof FormData) {
            delete requestOption.headers['Content-type'];
        }
        requestOption.body = data;
    }
    try {
        const reponse = await fetch(endpoint,method === 'GET' ? undefined : requestOption);
        if(reponse.type == 'cors' && reponse.redirected) {
            window.location.href =reponse.url;
        }
        return reponse;
    } catch (error) {
        console.error('API CALL ERROR', error);
        throw error;
    }
}

const apiClientService = {
    get: (endpoint: string)  => sendRequest('GET',endpoint),
    post: (endpoint: string,data: any,contentType: string | null = null) => sendRequest('POST',endpoint,data,contentType),
    put: (endpoint: string,data: any, contentType: string | null = null) => sendRequest('PUT',endpoint,data,contentType),
    delete: (endpoint : string) => sendRequest('DELETE',endpoint),
};

export default apiClientService;