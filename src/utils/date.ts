/**
 *
 * @param time 需要转换的时间
 * @param fmt  需要转换的格式 如：yyyy-MM-dd、yyyy-MM-dd HH:mm:ss
 */
export function formatTime(time: any,fmt:string){
    if(!time)return ''
    else {
        const date = new Date(time)
        const o = {
            'M+': date.getMonth()+1,// getMonth()返回值是0（一月）到11（十二月）之间的一个整数
            'd+': date.getDate(),// getDate()返回值1~31之间一个整数
            'H+': date.getHours(),//getHours()返回对象的小时（0~23）
            'm+': date.getMinutes(),// 返回对象的分钟(0~59)
            's+': date.getSeconds(),// 返回对象的秒数（0~59）
            'q+': Math.floor((date.getMonth()+3)/3),// 季度
            'S': date.getMilliseconds() // 毫秒，返回对象的毫秒（0~999）
        }

        // 处理年份
        /**
         * RegExp.$1: 指的是与正则表示匹配的第一个 子匹配（已括号为标志）字符串
         * getFullYear()： 返回一个表示年份的4位数据
         * 输出的结果如：2023-MM-dd
         */
        if(/(y+)/.test(fmt))fmt=fmt.replace(RegExp.$1,(date.getFullYear()+'').substr(4-RegExp.$1.length))

        // 遍历o对象
        for (const k in o){
            if(new RegExp('('+k+')').test(fmt)){
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : ((
                   '00' + o[k]).substr(('' + o[k]).length)))
            }
        }

        return fmt

    }
}

/**
 * 计算天数
 * @param time
 */
export function calculateDays(time: any) {
    if (!time)return ''
    else {
        let day = Math.floor(new Date().getTime() /1000)-(new Date(time).getTime() /1000)
        let  day2 = Math.floor(day/(24*3600))
        return day2
    }
}
