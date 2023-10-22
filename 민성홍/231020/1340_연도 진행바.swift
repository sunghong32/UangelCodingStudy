//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/20.
//  백준 1340: 연도 진행바
//  메모리: 79516 KB
//  시간: 12 ms

import Foundation

let today = readLine()!.split(separator: " ").map { String($0) }
let year = Int(today[2])
let month = today[0]
let day = Double(today[1].replacingOccurrences(of: ",", with: ""))
let time = today[3].split(separator: ":").map { String($0) }
let hour = Double(time[0])
let minute = Double(time[1])
let monthArray: [Double] = [31, (year! % 400 == 0) || ((year! % 4 == 0) && (year! % 100 != 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
let monthIndexArray = ["January": 0, "February": 1, "March": 2, "April": 3, "May": 4, "June": 5, "July": 6, "August": 7, "September": 8, "October": 9, "November": 10, "December": 11]

var fullDay: Double = (year! % 400 == 0) || ((year! % 4 == 0) && (year! % 100 != 0)) ? 366 * 24 * 60 : 365 * 24 * 60
var result: Double = 0
var tempSum: Double = 0

for i in 0..<monthIndexArray[month]! {
    tempSum += monthArray[i]
}

result = (((tempSum + day! - 1) * 1440) + hour! * 60 + minute!) / fullDay * 100

print(result)


